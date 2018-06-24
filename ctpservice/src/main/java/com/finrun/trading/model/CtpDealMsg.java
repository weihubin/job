package com.finrun.trading.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.finrun.trading.common.model.ctp.CThostFtdcTradeField;
import com.finrun.trading.common.utils.CtpUtil;

/**
 * Created by weihubin on 2018-05-30.
 */

public class CtpDealMsg implements Serializable{

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

    @JSONField (name = "exchangeId", ordinal = 6)
    private String exchangeId;

    @JSONField (name = "tradeId", ordinal = 7)
    private String tradeId;

    @JSONField (name = "direction", ordinal = 8)
    private String direction;

    @JSONField (name = "orderSysId", ordinal = 9)
    private String orderSysId;

    @JSONField (name = "participantId", ordinal = 10)
    private String participantId;

    @JSONField (name = "clientId", ordinal = 11)
    private String clientId;

    @JSONField (name = "tradingRole", ordinal = 12)
    private String tradingRole;

    @JSONField (name = "exchangeInstId", ordinal = 13)
    private String exchangeInstId;

    @JSONField (name = "offsetFlag", ordinal = 14)
    private String offsetFlag;

    @JSONField (name = "hedgeFlag", ordinal = 15)
    private String hedgeFlag;

    @JSONField (name = "price", ordinal = 16)
    private BigDecimal price;

    @JSONField (name = "volume", ordinal = 17)
    private BigDecimal volume;

    @JSONField (name = "tradeDate", ordinal = 18)
    private String tradeDate;

    @JSONField (name = "tradeTime", ordinal = 19)
    private String tradeTime;

    @JSONField (name = "tradeType", ordinal = 20)
    private String tradeType;

    @JSONField (name = "priceSource", ordinal = 21)
    private String priceSource;

    @JSONField (name = "traderId", ordinal = 22)
    private String traderId;

    @JSONField (name = "orderLocalId", ordinal = 23)
    private String orderLocalId;

    @JSONField (name = "clearingPartId", ordinal = 24)
    private String clearingPartId;

    @JSONField (name = "businessUnit", ordinal = 25)
    private String businessUnit;

    @JSONField (name = "sequenceNo", ordinal = 26)
    private BigDecimal sequenceNo;

    @JSONField (name = "tradingDay", ordinal = 27)
    private String tradingDay;

    @JSONField (name = "settlementId", ordinal = 28)
    private BigDecimal settlementId;

    @JSONField (name = "brokerOrderSeq", ordinal = 29)
    private BigDecimal brokerOrderSeq;

    @JSONField (name = "tradeSource", ordinal = 30)
    private String tradeSource;

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

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOrderSysId() {
        return orderSysId;
    }

    public void setOrderSysId(String orderSysId) {
        this.orderSysId = orderSysId;
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

    public String getTradingRole() {
        return tradingRole;
    }

    public void setTradingRole(String tradingRole) {
        this.tradingRole = tradingRole;
    }

    public String getExchangeInstId() {
        return exchangeInstId;
    }

    public void setExchangeInstId(String exchangeInstId) {
        this.exchangeInstId = exchangeInstId;
    }

    public String getOffsetFlag() {
        return offsetFlag;
    }

    public void setOffsetFlag(String offsetFlag) {
        this.offsetFlag = offsetFlag;
    }

    public String getHedgeFlag() {
        return hedgeFlag;
    }

    public void setHedgeFlag(String hedgeFlag) {
        this.hedgeFlag = hedgeFlag;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPriceSource() {
        return priceSource;
    }

    public void setPriceSource(String priceSource) {
        this.priceSource = priceSource;
    }

    public String getTraderId() {
        return traderId;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
    }

    public String getOrderLocalId() {
        return orderLocalId;
    }

    public void setOrderLocalId(String orderLocalId) {
        this.orderLocalId = orderLocalId;
    }

    public String getClearingPartId() {
        return clearingPartId;
    }

    public void setClearingPartId(String clearingPartId) {
        this.clearingPartId = clearingPartId;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public BigDecimal getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(BigDecimal sequenceNo) {
        this.sequenceNo = sequenceNo;
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

    public BigDecimal getBrokerOrderSeq() {
        return brokerOrderSeq;
    }

    public void setBrokerOrderSeq(BigDecimal brokerOrderSeq) {
        this.brokerOrderSeq = brokerOrderSeq;
    }

    public String getTradeSource() {
        return tradeSource;
    }

    public void setTradeSource(String tradeSource) {
        this.tradeSource = tradeSource;
    }


    public static CtpDealMsg transDealMsg(CThostFtdcTradeField p){
        CtpDealMsg deal = new CtpDealMsg();
        deal.setBrokerId(p.getBrokerID());
        deal.setInvestorId(p.getInvestorID());
        deal.setInstrumentId(p.getInstrumentID());
        deal.setOrderRef(p.getOrderRef());
        deal.setUserId(p.getUserID());
        deal.setExchangeId(p.getExchangeID());
        deal.setTradeId(p.getTradeID());
        deal.setDirection(String.valueOf(p.getDirection()));
        deal.setOrderSysId(p.getOrderSysID());
        deal.setParticipantId(p.getParticipantID());
        deal.setClientId(p.getClientID());
        deal.setTradingRole(String.valueOf(p.getTradingRole()));
        deal.setExchangeInstId(p.getExchangeInstID());
        deal.setOffsetFlag(String.valueOf(p.getOffsetFlag()));
        deal.setHedgeFlag(String.valueOf(p.getHedgeFlag()));
        deal.setPrice(CtpUtil.doubleToBigDecimal(p.getPrice()));
        deal.setVolume(CtpUtil.doubleToBigDecimal(p.getVolume()));
        deal.setTradeDate(p.getTradeDate());
        deal.setTradeTime(p.getTradeTime());
        deal.setTradeType(String.valueOf(p.getTradeType()));
        deal.setPriceSource(String.valueOf(p.getPriceSource()));
        deal.setTraderId(p.getTraderID());
        deal.setOrderLocalId(p.getOrderLocalID());
        deal.setClearingPartId(p.getClearingPartID());
        deal.setBusinessUnit(p.getBusinessUnit());
        deal.setSequenceNo(CtpUtil.doubleToBigDecimal(p.getSequenceNo()));
        deal.setTradingDay(p.getTradingDay());
        deal.setSettlementId(CtpUtil.doubleToBigDecimal(p.getSettlementID()));
        deal.setBrokerOrderSeq(CtpUtil.doubleToBigDecimal(p.getBrokerOrderSeq()));
        deal.setTradeSource(String.valueOf(p.getTradeSource()));
        return deal;
    }


}
