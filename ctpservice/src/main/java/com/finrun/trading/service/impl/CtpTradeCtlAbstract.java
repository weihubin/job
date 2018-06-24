package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.CONST;
import com.finrun.trading.common.ctp.CTPTradeAdaptor;
import com.finrun.trading.common.ctp.callback.CTPTradeCallback;
import com.finrun.trading.common.model.CtpTradeSingleton;
import com.finrun.trading.common.model.ctp.*;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.CtpQryInstrumentService;
import com.finrun.trading.service.CtpRspMsgSettleService;
import com.finrun.trading.service.CtpTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weihubin on 2018-04-04.
 */
public abstract class CtpTradeCtlAbstract {
    private static Logger LOGGER = LoggerFactory.getLogger(CtpTradeCtlAbstract.class);
    @Value("${ctp.ctpTradeFrontAddress}")
    protected String ctpTradeFrontAddress;
    @Value("${ctp.ctpMarketDataFrontAddress}")
    protected String ctpMarketDataFrontAddress;
    @Value("${ctp.ctpBrokerID}")
    protected String ctpBrokerID;
    @Value("${ctp.ctpUserID}")
    protected String ctpUserID;
    @Value("${ctp.ctpPassword}")
    protected String ctpPassword;

    @Autowired
    protected CtpRspMsgSettleService ctpRspMsgSettleService;

    //单例获取CTPTradeAdaptor对象
    protected CTPTradeAdaptor trade = CtpTradeSingleton.getInstance();

    private CtpTradeService ctpTradeService;
    public void setCtpTradeService(CtpTradeService ctpTradeService) {
        this.ctpTradeService = ctpTradeService;
    }

    private CtpQryInstrumentService ctpQryInstrumentService;

    public void setCtpQryInstrumentService(CtpQryInstrumentService ctpQryInstrumentService) {
        this.ctpQryInstrumentService = ctpQryInstrumentService;
    }

    public ResultDto ctpTradeCtl(String msg) throws Exception {
        String tradingDay = trade.getTradingDay(ctpUserID);
        if(!StringUtils.isEmpty(tradingDay)){ //已登录成功
            ctpTradeService.sendCtpTrade(msg);
            return ResultUtil.success();
        }
        conCtpLogin(new CTPTradeCallback() {
            @Override
            public void onFrontConnected() {
                LOGGER.info("CtpTradeCtlAbstract onFrontConnected !");
            }
            @Override
            public void onFrontDisconnected(int nReason) {
            }

            @Override
            public void onHeartBeatWarning(int nTimeLapse) {

            }

            @Override
            public void onRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                if(pRspUserLogin == null || pRspInfo ==null){
                    return;
                }
                if(0 == pRspInfo.getErrorID()){//登录成功
                    CThostFtdcSettlementInfoConfirmField confirmField = new CThostFtdcSettlementInfoConfirmField();
                    confirmField.setBrokerID(ctpBrokerID);
                    confirmField.setInvestorID(ctpUserID);
                    //交易日内首次登录时需要做投资者结算结果确认操作
                    trade.reqSettlementInfoConfirm(confirmField, new AtomicInteger().getAndIncrement(), ctpUserID);
                    ctpTradeService.sendCtpTrade(msg);
                    LOGGER.info("ctpTradeService end");
                }
            }

            @Override
            public void onRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("onRspUserLogout ={}" + pUserLogout);
            }

            @Override
            public void onRspUserPasswordUpdate(CThostFtdcUserPasswordUpdateField pUserPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspTradingAccountPasswordUpdate(CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                //报单录入请求响应, 报单录入回调，CTP表层判断即报单参数基本的校验，如校验不通过，会收到回调信息
               /* （1）典型错误：报单引用是否自增
                （2）典型错误：报单引用是否重复
                （3）典型错误：报单数量错误，如报卖量不足。有“平仓量超过持仓量”等*/
                LOGGER.info("onRspOrderInsert={} \r\n", pInputOrder, pRspInfo);
                ctpRspMsgSettleService.rspOrderInsertStl(pInputOrder, trade.getUserSession(ctpUserID), pRspInfo);
            }

            @Override
            public void onRspParkedOrderInsert(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("onRspParkedOrderInsert={} \r\n", pParkedOrder, pRspInfo);
            }

            @Override
            public void onRspParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspOrderAction(CThostFtdcInputOrderActionField pInputOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
            }

            @Override
            public void onRspQueryMaxOrderVolume(CThostFtdcQueryMaxOrderVolumeField pQueryMaxOrderVolume, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspSettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
            }

            @Override
            public void onRspRemoveParkedOrder(CThostFtdcRemoveParkedOrderField pRemoveParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspRemoveParkedOrderAction(CThostFtdcRemoveParkedOrderActionField pRemoveParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspExecOrderInsert(CThostFtdcInputExecOrderField pInputExecOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspExecOrderAction(CThostFtdcInputExecOrderActionField pInputExecOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspForQuoteInsert(CThostFtdcInputForQuoteField pInputForQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQuoteInsert(CThostFtdcInputQuoteField pInputQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQuoteAction(CThostFtdcInputQuoteActionField pInputQuoteAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspBatchOrderAction(CThostFtdcInputBatchOrderActionField pInputBatchOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspCombActionInsert(CThostFtdcInputCombActionField pInputCombAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryOrder(CThostFtdcOrderField pOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("onRspQryOrder={}\r\n{}", pOrder, pRspInfo);
            }

            @Override
            public void onRspQryTrade(CThostFtdcTradeField pTrade, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("onRspQryTrade={}\r\n{}", pTrade, pRspInfo);
            }

            @Override
            public void onRspQryInvestorPosition(CThostFtdcInvestorPositionField pInvestorPosition, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                if(pRspInfo == null || pInvestorPosition == null){
                    return;
                }
                if(0 == pRspInfo.getErrorID()){
                    ctpRspMsgSettleService.rspQryInvestorPosStl(pInvestorPosition);
                }
            }


            @Override
            public void onRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                if(pRspInfo == null || pTradingAccount == null){
                    return;
                }
                //settleTradingAccount
                if(0 == pRspInfo.getErrorID()){
                    ctpRspMsgSettleService.rspQryTradingAccountStl(pTradingAccount);
                }
            }

            @Override
            public void onRspQryInvestor(CThostFtdcInvestorField pInvestor, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryTradingCode(CThostFtdcTradingCodeField pTradingCode, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField pInstrumentMarginRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                //TODO

            }

            @Override
            public void onRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryExchange(CThostFtdcExchangeField pExchange, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryProduct(CThostFtdcProductField pProduct, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryTransferBank(CThostFtdcTransferBankField pTransferBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryInvestorPositionDetail(CThostFtdcInvestorPositionDetailField pInvestorPositionDetail, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryNotice(CThostFtdcNoticeField pNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQrySettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("onRspQrySettlementInfoConfirm={}\r\n{}", pSettlementInfoConfirm, pRspInfo);
            }

            @Override
            public void onRspQryInvestorPositionCombineDetail(CThostFtdcInvestorPositionCombineDetailField pInvestorPositionCombineDetail, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryCFMMCTradingAccountKey(CThostFtdcCFMMCTradingAccountKeyField pCFMMCTradingAccountKey, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryEWarrantOffset(CThostFtdcEWarrantOffsetField pEWarrantOffset, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryInvestorProductGroupMargin(CThostFtdcInvestorProductGroupMarginField pInvestorProductGroupMargin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryExchangeMarginRate(CThostFtdcExchangeMarginRateField pExchangeMarginRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryExchangeMarginRateAdjust(CThostFtdcExchangeMarginRateAdjustField pExchangeMarginRateAdjust, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryExchangeRate(CThostFtdcExchangeRateField pExchangeRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQrySecAgentACIDMap(CThostFtdcSecAgentACIDMapField pSecAgentACIDMap, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryProductExchRate(CThostFtdcProductExchRateField pProductExchRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryProductGroup(CThostFtdcProductGroupField pProductGroup, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryMMInstrumentCommissionRate(CThostFtdcMMInstrumentCommissionRateField pMMInstrumentCommissionRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryMMOptionInstrCommRate(CThostFtdcMMOptionInstrCommRateField pMMOptionInstrCommRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryInstrumentOrderCommRate(CThostFtdcInstrumentOrderCommRateField pInstrumentOrderCommRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryOptionInstrTradeCost(CThostFtdcOptionInstrTradeCostField pOptionInstrTradeCost, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryOptionInstrCommRate(CThostFtdcOptionInstrCommRateField pOptionInstrCommRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryExecOrder(CThostFtdcExecOrderField pExecOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryForQuote(CThostFtdcForQuoteField pForQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryQuote(CThostFtdcQuoteField pQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryCombInstrumentGuard(CThostFtdcCombInstrumentGuardField pCombInstrumentGuard, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryCombAction(CThostFtdcCombActionField pCombAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryTransferSerial(CThostFtdcTransferSerialField pTransferSerial, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryAccountregister(CThostFtdcAccountregisterField pAccountregister, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("onRspError={}", pRspInfo);
            }

            @Override
            public void onRtnOrder(CThostFtdcOrderField pOrder) {
                //报单回调。进行CTP深层判断和交易所层次判断, 只有报单状态的变化信息
                //（1）典型错误：非交易时段报单录入  (2）典型错误：报单的价格超过涨停价或跌停价。
                ctpRspMsgSettleService.rtnOrderStl(pOrder);
            }

            @Override
            public void onRtnTrade(CThostFtdcTradeField pTrade) {
                ctpRspMsgSettleService.rtnTradeStl(pTrade);
            }

            @Override
            public void onErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo) {
                LOGGER.info("onErrRtnOrderInsert={}", pRspInfo);
                //TODO
            }

            @Override
            public void onErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction, CThostFtdcRspInfoField pRspInfo) {
            }

            @Override
            public void onRtnInstrumentStatus(CThostFtdcInstrumentStatusField pInstrumentStatus) {

            }

            @Override
            public void onRtnBulletin(CThostFtdcBulletinField pBulletin) {

            }

            @Override
            public void onRtnTradingNotice(CThostFtdcTradingNoticeInfoField pTradingNoticeInfo) {

            }

            @Override
            public void onRtnErrorConditionalOrder(CThostFtdcErrorConditionalOrderField pErrorConditionalOrder) {

            }

            @Override
            public void onRtnExecOrder(CThostFtdcExecOrderField pExecOrder) {

            }

            @Override
            public void onErrRtnExecOrderInsert(CThostFtdcInputExecOrderField pInputExecOrder, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onErrRtnExecOrderAction(CThostFtdcExecOrderActionField pExecOrderAction, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onErrRtnForQuoteInsert(CThostFtdcInputForQuoteField pInputForQuote, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onRtnQuote(CThostFtdcQuoteField pQuote) {

            }

            @Override
            public void onErrRtnQuoteInsert(CThostFtdcInputQuoteField pInputQuote, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onErrRtnQuoteAction(CThostFtdcQuoteActionField pQuoteAction, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onRtnForQuoteRsp(CThostFtdcForQuoteRspField pForQuoteRsp) {

            }

            @Override
            public void onRtnCFMMCTradingAccountToken(CThostFtdcCFMMCTradingAccountTokenField pCFMMCTradingAccountToken) {

            }

            @Override
            public void onErrRtnBatchOrderAction(CThostFtdcBatchOrderActionField pBatchOrderAction, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onRtnCombAction(CThostFtdcCombActionField pCombAction) {

            }

            @Override
            public void onErrRtnCombActionInsert(CThostFtdcInputCombActionField pInputCombAction, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onRspQryContractBank(CThostFtdcContractBankField pContractBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryParkedOrder(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryTradingNotice(CThostFtdcTradingNoticeField pTradingNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryBrokerTradingParams(CThostFtdcBrokerTradingParamsField pBrokerTradingParams, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQryBrokerTradingAlgos(CThostFtdcBrokerTradingAlgosField pBrokerTradingAlgos, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQueryCFMMCTradingAccountToken(CThostFtdcQueryCFMMCTradingAccountTokenField pQueryCFMMCTradingAccountToken, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRtnFromBankToFutureByBank(CThostFtdcRspTransferField pRspTransfer) {

            }

            @Override
            public void onRtnFromFutureToBankByBank(CThostFtdcRspTransferField pRspTransfer) {

            }

            @Override
            public void onRtnRepealFromBankToFutureByBank(CThostFtdcRspRepealField pRspRepeal) {

            }

            @Override
            public void onRtnRepealFromFutureToBankByBank(CThostFtdcRspRepealField pRspRepeal) {

            }

            @Override
            public void onRtnFromBankToFutureByFuture(CThostFtdcRspTransferField pRspTransfer) {

            }

            @Override
            public void onRtnFromFutureToBankByFuture(CThostFtdcRspTransferField pRspTransfer) {

            }

            @Override
            public void onRtnRepealFromBankToFutureByFutureManual(CThostFtdcRspRepealField pRspRepeal) {

            }

            @Override
            public void onRtnRepealFromFutureToBankByFutureManual(CThostFtdcRspRepealField pRspRepeal) {

            }

            @Override
            public void onRtnQueryBankBalanceByFuture(CThostFtdcNotifyQueryAccountField pNotifyQueryAccount) {

            }

            @Override
            public void onErrRtnBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onErrRtnFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onErrRtnRepealBankToFutureByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onErrRtnRepealFutureToBankByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onErrRtnQueryBankBalanceByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo) {

            }

            @Override
            public void onRtnRepealFromBankToFutureByFuture(CThostFtdcRspRepealField pRspRepeal) {

            }

            @Override
            public void onRtnRepealFromFutureToBankByFuture(CThostFtdcRspRepealField pRspRepeal) {

            }

            @Override
            public void onRspFromBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspFromFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRspQueryBankAccountMoneyByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

            }

            @Override
            public void onRtnOpenAccountByBank(CThostFtdcOpenAccountField pOpenAccount) {

            }

            @Override
            public void onRtnCancelAccountByBank(CThostFtdcCancelAccountField pCancelAccount) {

            }

            @Override
            public void onRtnChangeAccountByBank(CThostFtdcChangeAccountField pChangeAccount) {

            }
        });
        return ResultUtil.success();
    }

    /**
     * 合约查询
     * @return
     * @throws Exception
     */
    public void qryInstrumentCtl() throws Exception {
        String tradingDay = trade.getTradingDay(ctpUserID);
        if(!StringUtils.isEmpty(tradingDay)){ //已登录成功
            ctpQryInstrumentService.ctpQryInstruments();
            return;
        }
        //登录
        conCtpLogin(null);
        ctpQryInstrumentService.ctpQryInstruments();
    }

    private void conCtpLogin(CTPTradeCallback ctpTradeCallback) throws Exception {
        AtomicInteger requestID = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(1);
        trade.createJVM(true, CONST.GLogLevel.INFO.getKey(), CONST.GLogLevel.ERROR.getKey(), null);
        trade.setLatch(latch);
        trade.initCtpCallback();
        trade.registerTradeCallback(ctpTradeCallback);
        try {
            Executors.newSingleThreadExecutor().submit(new Callable<Void>() {
                public Void call() throws Exception {
                    trade.ctpInit(ctpTradeFrontAddress, ctpUserID, "stream");
                    LOGGER.info("trade ctpInit end!");
                    return null;
                }
            });
        } catch (Exception e) {
            LOGGER.error("conCtpLogin ctpInit error:", e);
        }
        LOGGER.info("wait for connecting the front machine!");
        boolean ret = latch.await(10, TimeUnit.SECONDS);
        if (!ret) {
            LOGGER.warn("The ctp is not availabled now, skip to load instrument data from CTP!");
            return;
        }
        LOGGER.info("Connect to CTP front machine!");
        LOGGER.info("before user login");
        CThostFtdcReqUserLoginField pReqUserLoginField = new CThostFtdcReqUserLoginField();
        pReqUserLoginField.setBrokerID(ctpBrokerID);
        pReqUserLoginField.setUserID(ctpUserID);
        pReqUserLoginField.setPassword(ctpPassword);
        LOGGER.info("user logining");
        trade.reqUserLogin(pReqUserLoginField, requestID.incrementAndGet(), ctpUserID);
        LOGGER.info("user logined");
        TimeUnit.SECONDS.sleep(2);
    }

}
