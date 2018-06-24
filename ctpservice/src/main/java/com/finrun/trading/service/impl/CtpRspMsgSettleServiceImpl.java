package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.model.ctp.*;
import com.finrun.trading.mapper.*;
import com.finrun.trading.model.*;
import com.finrun.trading.service.CtpRspMsgSettleService;
import com.finrun.trading.service.QryInvestorPosService;
import com.finrun.trading.service.QryTradingAccService;
import com.finrun.trading.websocket.service.WebSocketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentMap;

/**
 * ctp异步回执消息处理
 * Created by weihubin on 2018-05-30.
 */
@Service
public class CtpRspMsgSettleServiceImpl implements CtpRspMsgSettleService {

    private static Logger LOGGER = LoggerFactory.getLogger(CtpRspMsgSettleServiceImpl.class);

    @Autowired
    private CtpInstrumentInfoMapper ctpInstrumentInfoMapper;
    @Autowired
    private CtpDepthMarketDataMapper ctpDepthMarketDataMapper;
    @Autowired
    private CtpTradingAccountMapper ctpTradingAccountMapper;
    @Autowired
    private CtpInvestorPosMapper ctpInvestorPosMapper;
    @Autowired
    private CtpReqOrdMapper ctpReqOrdMapper;
    @Autowired
    private CtpDealMsgMapper ctpDealMsgMapper;
    @Autowired
    private QryInvestorPosService qryInvestorPosService;
    @Autowired
    private QryTradingAccService qryTradingAccService;
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public CtpInstrumentInfo qryInstrumentInfoById(String instrumentID) {
        return ctpInstrumentInfoMapper.qryInstrumentInfoById(instrumentID);
    }

    @Transactional
    @Override
    public void rtnDepthMarketDataStl(CThostFtdcDepthMarketDataField pDepthMarketData) {
        CtpDepthMarketData marketData = CtpDepthMarketData.transDepthMarketData(pDepthMarketData);
        ctpDepthMarketDataMapper.insert(marketData);
        //TODO 保存到文件
        //TODO webSocketSender推送消息
        webSocketSender.sendMsgToAllClient(JSONObject.toJSONString(marketData));
    }

    @Transactional
    @Override
    public void updateAllInstruments(ConcurrentMap<String, CThostFtdcInstrumentField> instrumentMapAll) {
        //更新所有合约信息
        if(instrumentMapAll == null){
            return;
        }
        ctpInstrumentInfoMapper.deleteAll();
        for(String instInfo: instrumentMapAll.keySet()){
            CThostFtdcInstrumentField  instrumentField = instrumentMapAll.get(instInfo);
            CtpInstrumentInfo info = CtpInstrumentInfo.transInstrumentInfo(instrumentField);
            LOGGER.info("CtpInstrumentInfo insert:" + info);
            ctpInstrumentInfoMapper.insert(info);
        }
    }

    @Transactional
    @Override
    public void rspQryTradingAccountStl(CThostFtdcTradingAccountField pTradingAccount) {
        CtpTradingAccount tradingAccount = CtpTradingAccount.transTradingAccount(pTradingAccount);
        //根据brokerId、accountId查找数据库,若存在则更新，不存在则插入
        int count = ctpTradingAccountMapper.qryCountById(tradingAccount.getBrokerId(), tradingAccount.getAccountId());
        if(count > 0){
            ctpTradingAccountMapper.updateAllById(tradingAccount);
        }else {
            ctpTradingAccountMapper.insert(tradingAccount);
        }
        LOGGER.info("rspQryTradingAccountStl end:");
    }

    @Transactional
    @Override
    public void rspQryInvestorPosStl(CThostFtdcInvestorPositionField pInvestorPosition) {
        CtpInvestorPos pos = CtpInvestorPos.tranInvestorPos(pInvestorPosition);
        int count = ctpInvestorPosMapper.qryCountByPrimKey(pos);
        if(count > 0){
            ctpInvestorPosMapper.updateAllByPrimKey(pos);
        }else {
            ctpInvestorPosMapper.insert(pos);
        }
        LOGGER.info("rspQryInvestorPosStl end:");
    }

    @Transactional
    @Override
    public int saveInputOrder(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspUserLoginField userLoginField) {

        CtpReqOrd ord = CtpReqOrd.transReqOrd(pInputOrder, userLoginField);

        return ctpReqOrdMapper.insert(ord);

    }

    @Transactional
    @Override
    public void rspOrderInsertStl(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspUserLoginField userLoginField, CThostFtdcRspInfoField pRspInfo) {
        CtpReqOrd ord = CtpReqOrd.transReqOrd(pInputOrder, userLoginField);
        ord.setStatusMsg(pRspInfo.getErrorMsg());
        if(pRspInfo.getErrorID() != 0){
            ctpReqOrdMapper.updateAllByPrimKey(ord);
        }
        LOGGER.info("rspOrderInsertStl end:");
    }

    @Transactional
    @Override
    public void rtnOrderStl(CThostFtdcOrderField pOrder) {
        CtpReqOrd ord = CtpReqOrd.transReqOrd(pOrder);
        int count =ctpReqOrdMapper.qryCountByPrimKey(ord);
        if(count > 0){
            ctpReqOrdMapper.updateAllByPrimKey(ord);
        }else {
            ctpReqOrdMapper.insert(ord);
        }
        LOGGER.info("rtnOrderStl end:");
    }

    @Transactional
    @Override
    public void rtnTradeStl(CThostFtdcTradeField pTrade) {
        CtpDealMsg deal = CtpDealMsg.transDealMsg(pTrade);
        ctpDealMsgMapper.insert(deal);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("instrumentID", pTrade.getInstrumentID());
            String jsonMsg = jsonObject.toJSONString();
            //更新投资人持仓(只更新对应合约)
            qryInvestorPosService.qryInvestorPos(jsonMsg);
            //更新投资人资金信息(更新成交对应币种,但是成交未返回对应币种，暂时更新维度为投资人)
            qryTradingAccService.qryTradingAcc(jsonMsg);
        } catch (Exception e) {
            LOGGER.error("rtnTradeStl update pos and acc error:", e);
        }
        LOGGER.info("rtnTradeStl end:");
    }
}
