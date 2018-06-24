package com.finrun.trading.service;

import com.finrun.trading.common.model.ctp.*;
import com.finrun.trading.model.CtpInstrumentInfo;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by weihubin on 2018-05-30.
 */
public interface CtpRspMsgSettleService {
    /**
     * 根据合约id，查询合约信息
     * @param instrumentID
     * @return
     */
    CtpInstrumentInfo qryInstrumentInfoById(String instrumentID);

    /**
     * 深度行情处理
     * @param pDepthMarketData
     */
    void rtnDepthMarketDataStl(CThostFtdcDepthMarketDataField pDepthMarketData);


    /**
     * 更新所合约
     * @param instrumentMapAll
     */
    void updateAllInstruments(ConcurrentMap<String, CThostFtdcInstrumentField> instrumentMapAll);


    /**
     * 投资人资金账户信息处理
     * @param pTradingAccount
     */
    void rspQryTradingAccountStl(CThostFtdcTradingAccountField pTradingAccount);

    /**
     * 返回投资人持仓信息处理
     * @param pInvestorPosition
     */
    void rspQryInvestorPosStl(CThostFtdcInvestorPositionField pInvestorPosition);


    /**
     * 保存提交单
     * @param pInputOrder
     * @param userLoginField
     * @return
     */
    int saveInputOrder(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspUserLoginField userLoginField);


    /**
     * 报单录入回执
     * @param pInputOrder
     * @param userLoginField
     */
    void rspOrderInsertStl(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspUserLoginField userLoginField, CThostFtdcRspInfoField pRspInfo);


    /**
     * 深层报单校验，返回报单信息(可能包含报单错误的信息)
     * @param pOrder
     */
    void rtnOrderStl(CThostFtdcOrderField pOrder);

    /**
     * 成交通知
     * @param pTrade
     * @return
     */
    void rtnTradeStl(CThostFtdcTradeField pTrade);

}
