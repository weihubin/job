package com.finrun.trading.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.finrun.trading.common.model.ctp.CThostFtdcInputOrderField;
import com.finrun.trading.common.model.ctp.CThostFtdcOrderField;
import com.finrun.trading.common.model.ctp.CThostFtdcRspUserLoginField;
import com.finrun.trading.common.utils.CtpUtil;

/**
 * Created by weihubin on 2018-05-30.
 */
public class CtpReqOrd implements Serializable{
    @JSONField (name = "brokerId", ordinal = 1)
    private String brokerId;

    @JSONField (name = "investorId", ordinal = 2)
    private String investorId;

    @JSONField (name = "instrumentId", ordinal = 3)
    private String instrumentId;

    @JSONField (name = "orderRef", ordinal = 4)
    private String orderRef;

    @JSONField (name = "userId", ordinal = 5)
    private String userId;

    @JSONField (name = "orderPriceType", ordinal = 6)
    private String orderPriceType;

    @JSONField (name = "direction", ordinal = 7)
    private String direction;

    @JSONField (name = "combOffsetFlag", ordinal = 8)
    private String combOffsetFlag;

    @JSONField (name = "combHedgeFlag", ordinal = 9)
    private String combHedgeFlag;

    @JSONField (name = "limitPrice", ordinal = 10)
    private BigDecimal limitPrice;

    @JSONField (name = "volumeTotalOriginal", ordinal = 11)
    private BigDecimal volumeTotalOriginal;

    @JSONField (name = "timeCondition", ordinal = 12)
    private String timeCondition;

    @JSONField (name = "gtdDate", ordinal = 13)
    private String gtdDate;

    @JSONField (name = "volumeCondition", ordinal = 14)
    private String volumeCondition;

    @JSONField (name = "minVolume", ordinal = 15)
    private BigDecimal minVolume;

    @JSONField (name = "contingentCondition", ordinal = 16)
    private String contingentCondition;

    @JSONField (name = "stopPrice", ordinal = 17)
    private BigDecimal stopPrice;

    @JSONField (name = "forceCloseReason", ordinal = 18)
    private String forceCloseReason;

    @JSONField (name = "isAutoSuspend", ordinal = 19)
    private BigDecimal isAutoSuspend;

    @JSONField (name = "businessUnit", ordinal = 20)
    private String businessUnit;

    @JSONField (name = "requestId", ordinal = 21)
    private BigDecimal requestId;

    @JSONField (name = "orderLocalId", ordinal = 22)
    private String orderLocalId;

    @JSONField (name = "exchangeId", ordinal = 23)
    private String exchangeId;

    @JSONField (name = "participantId", ordinal = 24)
    private String participantId;

    @JSONField (name = "clientId", ordinal = 25)
    private String clientId;

    @JSONField (name = "exchangeInstId", ordinal = 26)
    private String exchangeInstId;

    @JSONField (name = "traderId", ordinal = 27)
    private String traderId;

    @JSONField (name = "installId", ordinal = 28)
    private BigDecimal installId;

    @JSONField (name = "orderSubmitStatus", ordinal = 29)
    private String orderSubmitStatus;

    @JSONField (name = "notifySequence", ordinal = 30)
    private BigDecimal notifySequence;

    @JSONField (name = "tradingDay", ordinal = 31)
    private String tradingDay;

    @JSONField (name = "settlementId", ordinal = 32)
    private BigDecimal settlementId;

    @JSONField (name = "orderSysId", ordinal = 33)
    private String orderSysId;

    @JSONField (name = "orderSource", ordinal = 34)
    private String orderSource;

    @JSONField (name = "orderStatus", ordinal = 35)
    private String orderStatus;

    @JSONField (name = "orderType", ordinal = 36)
    private String orderType;

    @JSONField (name = "volumeTraded", ordinal = 37)
    private BigDecimal volumeTraded;

    @JSONField (name = "volumeTotal", ordinal = 38)
    private BigDecimal volumeTotal;

    @JSONField (name = "insertDate", ordinal = 39)
    private String insertDate;

    @JSONField (name = "insertTime", ordinal = 40)
    private String insertTime;

    @JSONField (name = "activeTime", ordinal = 41)
    private String activeTime;

    @JSONField (name = "suspendTime", ordinal = 42)
    private String suspendTime;

    @JSONField (name = "updateTime", ordinal = 43)
    private String updateTime;

    @JSONField (name = "cancelTime", ordinal = 44)
    private String cancelTime;

    @JSONField (name = "activeTraderId", ordinal = 45)
    private String activeTraderId;

    @JSONField (name = "clearingPartId", ordinal = 46)
    private String clearingPartId;

    @JSONField (name = "sequenceNo", ordinal = 47)
    private BigDecimal sequenceNo;

    @JSONField (name = "frontId", ordinal = 48)
    private BigDecimal frontId;

    @JSONField (name = "sessionId", ordinal = 49)
    private BigDecimal sessionId;

    @JSONField (name = "userProductInfo", ordinal = 50)
    private String userProductInfo;

    @JSONField (name = "statusMsg", ordinal = 51)
    private String statusMsg;

    @JSONField (name = "userForceClose", ordinal = 52)
    private BigDecimal userForceClose;

    @JSONField (name = "activeUserId", ordinal = 53)
    private String activeUserId;

    @JSONField (name = "brokerOrderSeq", ordinal = 54)
    private BigDecimal brokerOrderSeq;

    @JSONField (name = "relativeOrderSysId", ordinal = 55)
    private String relativeOrderSysId;

    @JSONField (name = "zceTotalTradedVolume", ordinal = 56)
    private BigDecimal zceTotalTradedVolume;

    @JSONField (name = "isSwapOrder", ordinal = 57)
    private BigDecimal isSwapOrder;

    @JSONField (name = "branchId", ordinal = 58)
    private String branchId;

    @JSONField (name = "investUnitId", ordinal = 59)
    private String investUnitId;

    @JSONField (name = "accountId", ordinal = 60)
    private String accountId;

    @JSONField (name = "currencyId", ordinal = 61)
    private String currencyId;

    @JSONField (name = "ipAddress", ordinal = 62)
    private String ipAddress;

    @JSONField (name = "macAddress", ordinal = 63)
    private String macAddress;

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderPriceType() {
        return orderPriceType;
    }

    public void setOrderPriceType(String orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCombOffsetFlag() {
        return combOffsetFlag;
    }

    public void setCombOffsetFlag(String combOffsetFlag) {
        this.combOffsetFlag = combOffsetFlag;
    }

    public String getCombHedgeFlag() {
        return combHedgeFlag;
    }

    public void setCombHedgeFlag(String combHedgeFlag) {
        this.combHedgeFlag = combHedgeFlag;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
    }

    public BigDecimal getVolumeTotalOriginal() {
        return volumeTotalOriginal;
    }

    public void setVolumeTotalOriginal(BigDecimal volumeTotalOriginal) {
        this.volumeTotalOriginal = volumeTotalOriginal;
    }

    public String getTimeCondition() {
        return timeCondition;
    }

    public void setTimeCondition(String timeCondition) {
        this.timeCondition = timeCondition;
    }

    public String getGtdDate() {
        return gtdDate;
    }

    public void setGtdDate(String gtdDate) {
        this.gtdDate = gtdDate;
    }

    public String getVolumeCondition() {
        return volumeCondition;
    }

    public void setVolumeCondition(String volumeCondition) {
        this.volumeCondition = volumeCondition;
    }

    public BigDecimal getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(BigDecimal minVolume) {
        this.minVolume = minVolume;
    }

    public String getContingentCondition() {
        return contingentCondition;
    }

    public void setContingentCondition(String contingentCondition) {
        this.contingentCondition = contingentCondition;
    }

    public BigDecimal getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(BigDecimal stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getForceCloseReason() {
        return forceCloseReason;
    }

    public void setForceCloseReason(String forceCloseReason) {
        this.forceCloseReason = forceCloseReason;
    }

    public BigDecimal getIsAutoSuspend() {
        return isAutoSuspend;
    }

    public void setIsAutoSuspend(BigDecimal isAutoSuspend) {
        this.isAutoSuspend = isAutoSuspend;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public BigDecimal getRequestId() {
        return requestId;
    }

    public void setRequestId(BigDecimal requestId) {
        this.requestId = requestId;
    }

    public String getOrderLocalId() {
        return orderLocalId;
    }

    public void setOrderLocalId(String orderLocalId) {
        this.orderLocalId = orderLocalId;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getExchangeInstId() {
        return exchangeInstId;
    }

    public void setExchangeInstId(String exchangeInstId) {
        this.exchangeInstId = exchangeInstId;
    }

    public String getTraderId() {
        return traderId;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
    }

    public BigDecimal getInstallId() {
        return installId;
    }

    public void setInstallId(BigDecimal installId) {
        this.installId = installId;
    }

    public String getOrderSubmitStatus() {
        return orderSubmitStatus;
    }

    public void setOrderSubmitStatus(String orderSubmitStatus) {
        this.orderSubmitStatus = orderSubmitStatus;
    }

    public BigDecimal getNotifySequence() {
        return notifySequence;
    }

    public void setNotifySequence(BigDecimal notifySequence) {
        this.notifySequence = notifySequence;
    }

    public String getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }

    public BigDecimal getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(BigDecimal settlementId) {
        this.settlementId = settlementId;
    }

    public String getOrderSysId() {
        return orderSysId;
    }

    public void setOrderSysId(String orderSysId) {
        this.orderSysId = orderSysId;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getVolumeTraded() {
        return volumeTraded;
    }

    public void setVolumeTraded(BigDecimal volumeTraded) {
        this.volumeTraded = volumeTraded;
    }

    public BigDecimal getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(BigDecimal volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public String getSuspendTime() {
        return suspendTime;
    }

    public void setSuspendTime(String suspendTime) {
        this.suspendTime = suspendTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getActiveTraderId() {
        return activeTraderId;
    }

    public void setActiveTraderId(String activeTraderId) {
        this.activeTraderId = activeTraderId;
    }

    public String getClearingPartId() {
        return clearingPartId;
    }

    public void setClearingPartId(String clearingPartId) {
        this.clearingPartId = clearingPartId;
    }

    public BigDecimal getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(BigDecimal sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public BigDecimal getFrontId() {
        return frontId;
    }

    public void setFrontId(BigDecimal frontId) {
        this.frontId = frontId;
    }

    public BigDecimal getSessionId() {
        return sessionId;
    }

    public void setSessionId(BigDecimal sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserProductInfo() {
        return userProductInfo;
    }

    public void setUserProductInfo(String userProductInfo) {
        this.userProductInfo = userProductInfo;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public BigDecimal getUserForceClose() {
        return userForceClose;
    }

    public void setUserForceClose(BigDecimal userForceClose) {
        this.userForceClose = userForceClose;
    }

    public String getActiveUserId() {
        return activeUserId;
    }

    public void setActiveUserId(String activeUserId) {
        this.activeUserId = activeUserId;
    }

    public BigDecimal getBrokerOrderSeq() {
        return brokerOrderSeq;
    }

    public void setBrokerOrderSeq(BigDecimal brokerOrderSeq) {
        this.brokerOrderSeq = brokerOrderSeq;
    }

    public String getRelativeOrderSysId() {
        return relativeOrderSysId;
    }

    public void setRelativeOrderSysId(String relativeOrderSysId) {
        this.relativeOrderSysId = relativeOrderSysId;
    }

    public BigDecimal getZceTotalTradedVolume() {
        return zceTotalTradedVolume;
    }

    public void setZceTotalTradedVolume(BigDecimal zceTotalTradedVolume) {
        this.zceTotalTradedVolume = zceTotalTradedVolume;
    }

    public BigDecimal getIsSwapOrder() {
        return isSwapOrder;
    }

    public void setIsSwapOrder(BigDecimal isSwapOrder) {
        this.isSwapOrder = isSwapOrder;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getInvestUnitId() {
        return investUnitId;
    }

    public void setInvestUnitId(String investUnitId) {
        this.investUnitId = investUnitId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }


    /**
     * 报单录入转换
     * @param p
     * @param userLoginField
     * @return
     */
    public static CtpReqOrd transReqOrd(CThostFtdcInputOrderField p, CThostFtdcRspUserLoginField userLoginField){
        CtpReqOrd ord = new CtpReqOrd();
        ord.setBrokerId(p.getBrokerID());
        ord.setInvestorId(p.getInvestorID());
        ord.setInstrumentId(p.getInstrumentID());
        ord.setOrderRef(p.getOrderRef());
        ord.setUserId(p.getUserID());
        ord.setOrderPriceType(String.valueOf(p.getOrderPriceType()));
        ord.setDirection(String.valueOf(p.getDirection()));
        ord.setCombOffsetFlag(p.getCombOffsetFlag());
        ord.setCombHedgeFlag(p.getCombHedgeFlag());
        ord.setLimitPrice(CtpUtil.doubleToBigDecimal(p.getLimitPrice()));
        ord.setVolumeTotalOriginal(CtpUtil.doubleToBigDecimal(p.getVolumeTotalOriginal()));
        ord.setTimeCondition(String.valueOf(p.getTimeCondition()));
        ord.setGtdDate(p.getGtdDate());
        ord.setVolumeCondition(String.valueOf(p.getVolumeCondition()));
        ord.setMinVolume(CtpUtil.doubleToBigDecimal(p.getMinVolume()));
        ord.setContingentCondition(String.valueOf(p.getContingentCondition()));
        ord.setStopPrice(CtpUtil.doubleToBigDecimal(p.getStopPrice()));
        ord.setForceCloseReason(String.valueOf(p.getForceCloseReason()));
        ord.setIsAutoSuspend(CtpUtil.doubleToBigDecimal(p.getIsAutoSuspend()));
        ord.setBusinessUnit(p.getBusinessUnit());
        ord.setRequestId(CtpUtil.doubleToBigDecimal(p.getRequestID()));
        ord.setUserForceClose(CtpUtil.doubleToBigDecimal(p.getUserForceClose()));
        ord.setIsSwapOrder(CtpUtil.doubleToBigDecimal(p.getIsSwapOrder()));

        ord.setFrontId(CtpUtil.doubleToBigDecimal(userLoginField.getFrontID()));
        ord.setSessionId(CtpUtil.doubleToBigDecimal(userLoginField.getSessionID()));
        return ord;
    }


    /**
     * 报单回执，转换
     * @param p
     * @return
     */
    public static CtpReqOrd transReqOrd(CThostFtdcOrderField p){
        CtpReqOrd ord = new CtpReqOrd();
        ord.setBrokerId(p.getBrokerID());
        ord.setInvestorId(p.getInvestorID());
        ord.setInstrumentId(p.getInstrumentID());
        ord.setOrderRef(p.getOrderRef());
        ord.setUserId(p.getUserID());
        ord.setOrderPriceType(String.valueOf(p.getOrderPriceType()));
        ord.setDirection(String.valueOf(p.getDirection()));
        ord.setCombOffsetFlag(p.getCombOffsetFlag());
        ord.setCombHedgeFlag(p.getCombHedgeFlag());
        ord.setLimitPrice(CtpUtil.doubleToBigDecimal(p.getLimitPrice()));
        ord.setVolumeTotalOriginal(CtpUtil.doubleToBigDecimal(p.getVolumeTotalOriginal()));
        ord.setTimeCondition(String.valueOf(p.getTimeCondition()));
        ord.setGtdDate(p.getGtdDate());
        ord.setVolumeCondition(String.valueOf(p.getVolumeCondition()));
        ord.setMinVolume(CtpUtil.doubleToBigDecimal(p.getMinVolume()));
        ord.setContingentCondition(String.valueOf(p.getContingentCondition()));
        ord.setStopPrice(CtpUtil.doubleToBigDecimal(p.getStopPrice()));
        ord.setForceCloseReason(String.valueOf(p.getForceCloseReason()));
        ord.setIsAutoSuspend(CtpUtil.doubleToBigDecimal(p.getIsAutoSuspend()));
        ord.setBusinessUnit(p.getBusinessUnit());
        ord.setRequestId(CtpUtil.doubleToBigDecimal(p.getRequestID()));
        ord.setOrderLocalId(p.getOrderLocalID());
        ord.setExchangeId(p.getExchangeID());
        ord.setParticipantId(p.getParticipantID());
        ord.setClientId(p.getClientID());
        ord.setExchangeInstId(p.getExchangeInstID());
        ord.setTraderId(p.getTraderID());
        ord.setInstallId(CtpUtil.doubleToBigDecimal(p.getInstallID()));
        ord.setOrderSubmitStatus(String.valueOf(p.getOrderSubmitStatus()));
        ord.setNotifySequence(CtpUtil.doubleToBigDecimal(p.getNotifySequence()));
        ord.setTradingDay(p.getTradingDay());
        ord.setSettlementId(CtpUtil.doubleToBigDecimal(p.getSettlementID()));
        ord.setOrderSysId(p.getOrderSysID());
        ord.setOrderSource(String.valueOf(p.getOrderSource()));
        ord.setOrderStatus(String.valueOf(p.getOrderStatus()));
        ord.setOrderType(String.valueOf(p.getOrderType()));
        ord.setVolumeTraded(CtpUtil.doubleToBigDecimal(p.getVolumeTraded()));
        ord.setVolumeTotal(CtpUtil.doubleToBigDecimal(p.getVolumeTotal()));
        ord.setInsertDate(p.getInsertDate());
        ord.setInsertTime(p.getInsertTime());
        ord.setActiveTime(p.getActiveTime());
        ord.setSuspendTime(p.getSuspendTime());
        ord.setUpdateTime(p.getUpdateTime());
        ord.setCancelTime(p.getCancelTime());
        ord.setActiveTraderId(p.getActiveTraderID());
        ord.setClearingPartId(p.getClearingPartID());
        ord.setSequenceNo(CtpUtil.doubleToBigDecimal(p.getSequenceNo()));
        ord.setFrontId(CtpUtil.doubleToBigDecimal(p.getFrontID()));
        ord.setSessionId(CtpUtil.doubleToBigDecimal(p.getSessionID()));
        ord.setUserProductInfo(p.getUserProductInfo());
        ord.setStatusMsg(p.getStatusMsg());
        ord.setUserForceClose(CtpUtil.doubleToBigDecimal(p.getUserForceClose()));
        ord.setActiveUserId(p.getActiveUserID());
        ord.setBrokerOrderSeq(CtpUtil.doubleToBigDecimal(p.getBrokerOrderSeq()));
        ord.setRelativeOrderSysId(p.getRelativeOrderSysID());
        ord.setZceTotalTradedVolume(CtpUtil.doubleToBigDecimal(p.getZceTotalTradedVolume()));
        ord.setIsSwapOrder(CtpUtil.doubleToBigDecimal(p.getIsSwapOrder()));
        ord.setBranchId(p.getBranchID());
        ord.setInvestUnitId(p.getInvestUnitID());
        ord.setAccountId(p.getAccountID());
        ord.setCurrencyId(p.getCurrencyID());
        ord.setIpAddress(p.getIpAddress());
        ord.setMacAddress(p.getMacAddress());
        return ord;
    }

}