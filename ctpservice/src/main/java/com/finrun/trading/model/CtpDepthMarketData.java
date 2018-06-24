package com.finrun.trading.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.finrun.trading.common.model.ctp.CThostFtdcDepthMarketDataField;
import com.finrun.trading.common.utils.StringUtil;
import com.finrun.trading.common.utils.CtpUtil;

public class CtpDepthMarketData implements Serializable{

    @JSONField (name = "objectId", ordinal = 1)
    private String objectId;

    @JSONField (name = "tradingDay", ordinal = 2)
    private String tradingDay;

    @JSONField (name = "instrumentId", ordinal = 3)
    private String instrumentId;

    @JSONField (name = "exchangeId", ordinal = 4)
    private String exchangeId;

    @JSONField (name = "exchangeInstId", ordinal = 5)
    private String exchangeInstId;

    @JSONField (name = "lastPrice", ordinal = 6)
    private BigDecimal lastPrice;

    @JSONField (name = "preSettlementPrice", ordinal = 7)
    private BigDecimal preSettlementPrice;

    @JSONField (name = "preClosePrice", ordinal = 8)
    private BigDecimal preClosePrice;

    @JSONField (name = "preOpenInterest", ordinal = 9)
    private BigDecimal preOpenInterest;

    @JSONField (name = "openPrice", ordinal = 10)
    private BigDecimal openPrice;

    @JSONField (name = "highestPrice", ordinal = 11)
    private BigDecimal highestPrice;

    @JSONField (name = "lowestPrice", ordinal = 12)
    private BigDecimal lowestPrice;

    @JSONField (name = "volume", ordinal = 13)
    private BigDecimal volume;

    @JSONField (name = "turnover", ordinal = 14)
    private BigDecimal turnover;

    @JSONField (name = "openInterest", ordinal = 15)
    private BigDecimal openInterest;

    @JSONField (name = "closePrice", ordinal = 16)
    private BigDecimal closePrice;

    @JSONField (name = "settlementPrice", ordinal = 17)
    private BigDecimal settlementPrice;

    @JSONField (name = "upperLimitPrice", ordinal = 18)
    private BigDecimal upperLimitPrice;

    @JSONField (name = "lowerLimitPrice", ordinal = 19)
    private BigDecimal lowerLimitPrice;

    @JSONField (name = "preDelta", ordinal = 20)
    private BigDecimal preDelta;

    @JSONField (name = "currDelta", ordinal = 21)
    private BigDecimal currDelta;

    @JSONField (name = "updateTime", ordinal = 22)
    private String updateTime;

    @JSONField (name = "updateMilliSec", ordinal = 23)
    private BigDecimal updateMilliSec;

    @JSONField (name = "bidPrice1", ordinal = 24)
    private BigDecimal bidPrice1;

    @JSONField (name = "bidVolume1", ordinal = 25)
    private BigDecimal bidVolume1;

    @JSONField (name = "askPrice1", ordinal = 26)
    private BigDecimal askPrice1;

    @JSONField (name = "askVolume1", ordinal = 27)
    private BigDecimal askVolume1;

    @JSONField (name = "bidPrice2", ordinal = 28)
    private BigDecimal bidPrice2;

    @JSONField (name = "bidVolume2", ordinal = 29)
    private BigDecimal bidVolume2;

    @JSONField (name = "askPrice2", ordinal = 30)
    private BigDecimal askPrice2;

    @JSONField (name = "askVolume2", ordinal = 31)
    private BigDecimal askVolume2;

    @JSONField (name = "bidPrice3", ordinal = 32)
    private BigDecimal bidPrice3;

    @JSONField (name = "bidVolume3", ordinal = 33)
    private BigDecimal bidVolume3;

    @JSONField (name = "askPrice3", ordinal = 34)
    private BigDecimal askPrice3;

    @JSONField (name = "askVolume3", ordinal = 35)
    private BigDecimal askVolume3;

    @JSONField (name = "bidPrice4", ordinal = 36)
    private BigDecimal bidPrice4;

    @JSONField (name = "bidVolume4", ordinal = 37)
    private BigDecimal bidVolume4;

    @JSONField (name = "askPrice4", ordinal = 38)
    private BigDecimal askPrice4;

    @JSONField (name = "askVolume4", ordinal = 39)
    private BigDecimal askVolume4;

    @JSONField (name = "bidPrice5", ordinal = 40)
    private BigDecimal bidPrice5;

    @JSONField (name = "bidVolume5", ordinal = 41)
    private BigDecimal bidVolume5;

    @JSONField (name = "askPrice5", ordinal = 42)
    private BigDecimal askPrice5;

    @JSONField (name = "askVolume5", ordinal = 43)
    private BigDecimal askVolume5;

    @JSONField (name = "averagePrice", ordinal = 44)
    private BigDecimal averagePrice;

    @JSONField (name = "actionDay", ordinal = 45)
    private String actionDay;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getExchangeInstId() {
        return exchangeInstId;
    }

    public void setExchangeInstId(String exchangeInstId) {
        this.exchangeInstId = exchangeInstId;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getPreSettlementPrice() {
        return preSettlementPrice;
    }

    public void setPreSettlementPrice(BigDecimal preSettlementPrice) {
        this.preSettlementPrice = preSettlementPrice;
    }

    public BigDecimal getPreClosePrice() {
        return preClosePrice;
    }

    public void setPreClosePrice(BigDecimal preClosePrice) {
        this.preClosePrice = preClosePrice;
    }

    public BigDecimal getPreOpenInterest() {
        return preOpenInterest;
    }

    public void setPreOpenInterest(BigDecimal preOpenInterest) {
        this.preOpenInterest = preOpenInterest;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(BigDecimal openInterest) {
        this.openInterest = openInterest;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public BigDecimal getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public void setUpperLimitPrice(BigDecimal upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public BigDecimal getLowerLimitPrice() {
        return lowerLimitPrice;
    }

    public void setLowerLimitPrice(BigDecimal lowerLimitPrice) {
        this.lowerLimitPrice = lowerLimitPrice;
    }

    public BigDecimal getPreDelta() {
        return preDelta;
    }

    public void setPreDelta(BigDecimal preDelta) {
        this.preDelta = preDelta;
    }

    public BigDecimal getCurrDelta() {
        return currDelta;
    }

    public void setCurrDelta(BigDecimal currDelta) {
        this.currDelta = currDelta;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getUpdateMilliSec() {
        return updateMilliSec;
    }

    public void setUpdateMilliSec(BigDecimal updateMilliSec) {
        this.updateMilliSec = updateMilliSec;
    }

    public BigDecimal getBidPrice1() {
        return bidPrice1;
    }

    public void setBidPrice1(BigDecimal bidPrice1) {
        this.bidPrice1 = bidPrice1;
    }

    public BigDecimal getBidVolume1() {
        return bidVolume1;
    }

    public void setBidVolume1(BigDecimal bidVolume1) {
        this.bidVolume1 = bidVolume1;
    }

    public BigDecimal getAskPrice1() {
        return askPrice1;
    }

    public void setAskPrice1(BigDecimal askPrice1) {
        this.askPrice1 = askPrice1;
    }

    public BigDecimal getAskVolume1() {
        return askVolume1;
    }

    public void setAskVolume1(BigDecimal askVolume1) {
        this.askVolume1 = askVolume1;
    }

    public BigDecimal getBidPrice2() {
        return bidPrice2;
    }

    public void setBidPrice2(BigDecimal bidPrice2) {
        this.bidPrice2 = bidPrice2;
    }

    public BigDecimal getBidVolume2() {
        return bidVolume2;
    }

    public void setBidVolume2(BigDecimal bidVolume2) {
        this.bidVolume2 = bidVolume2;
    }

    public BigDecimal getAskPrice2() {
        return askPrice2;
    }

    public void setAskPrice2(BigDecimal askPrice2) {
        this.askPrice2 = askPrice2;
    }

    public BigDecimal getAskVolume2() {
        return askVolume2;
    }

    public void setAskVolume2(BigDecimal askVolume2) {
        this.askVolume2 = askVolume2;
    }

    public BigDecimal getBidPrice3() {
        return bidPrice3;
    }

    public void setBidPrice3(BigDecimal bidPrice3) {
        this.bidPrice3 = bidPrice3;
    }

    public BigDecimal getBidVolume3() {
        return bidVolume3;
    }

    public void setBidVolume3(BigDecimal bidVolume3) {
        this.bidVolume3 = bidVolume3;
    }

    public BigDecimal getAskPrice3() {
        return askPrice3;
    }

    public void setAskPrice3(BigDecimal askPrice3) {
        this.askPrice3 = askPrice3;
    }

    public BigDecimal getAskVolume3() {
        return askVolume3;
    }

    public void setAskVolume3(BigDecimal askVolume3) {
        this.askVolume3 = askVolume3;
    }

    public BigDecimal getBidPrice4() {
        return bidPrice4;
    }

    public void setBidPrice4(BigDecimal bidPrice4) {
        this.bidPrice4 = bidPrice4;
    }

    public BigDecimal getBidVolume4() {
        return bidVolume4;
    }

    public void setBidVolume4(BigDecimal bidVolume4) {
        this.bidVolume4 = bidVolume4;
    }

    public BigDecimal getAskPrice4() {
        return askPrice4;
    }

    public void setAskPrice4(BigDecimal askPrice4) {
        this.askPrice4 = askPrice4;
    }

    public BigDecimal getAskVolume4() {
        return askVolume4;
    }

    public void setAskVolume4(BigDecimal askVolume4) {
        this.askVolume4 = askVolume4;
    }

    public BigDecimal getBidPrice5() {
        return bidPrice5;
    }

    public void setBidPrice5(BigDecimal bidPrice5) {
        this.bidPrice5 = bidPrice5;
    }

    public BigDecimal getBidVolume5() {
        return bidVolume5;
    }

    public void setBidVolume5(BigDecimal bidVolume5) {
        this.bidVolume5 = bidVolume5;
    }

    public BigDecimal getAskPrice5() {
        return askPrice5;
    }

    public void setAskPrice5(BigDecimal askPrice5) {
        this.askPrice5 = askPrice5;
    }

    public BigDecimal getAskVolume5() {
        return askVolume5;
    }

    public void setAskVolume5(BigDecimal askVolume5) {
        this.askVolume5 = askVolume5;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getActionDay() {
        return actionDay;
    }

    public void setActionDay(String actionDay) {
        this.actionDay = actionDay;
    }


    /**
     * PO转换
     * @param p
     * @return
     */
    public static CtpDepthMarketData transDepthMarketData(CThostFtdcDepthMarketDataField p){
        CtpDepthMarketData ctpDepthMarketData = new CtpDepthMarketData();
        ctpDepthMarketData.setObjectId(StringUtil.uuid());
        ctpDepthMarketData.setTradingDay(p.getTradingDay());
        ctpDepthMarketData.setInstrumentId(p.getInstrumentID());
        ctpDepthMarketData.setExchangeId(p.getExchangeID());
        ctpDepthMarketData.setExchangeInstId(p.getExchangeInstID());
        ctpDepthMarketData.setLastPrice(CtpUtil.doubleToBigDecimal(p.getLastPrice()));
        ctpDepthMarketData.setPreSettlementPrice(CtpUtil.doubleToBigDecimal(p.getPreSettlementPrice()));
        ctpDepthMarketData.setPreClosePrice(CtpUtil.doubleToBigDecimal(p.getPreClosePrice()));
        ctpDepthMarketData.setPreOpenInterest(CtpUtil.doubleToBigDecimal(p.getPreOpenInterest()));
        ctpDepthMarketData.setOpenPrice(CtpUtil.doubleToBigDecimal(p.getOpenPrice()));
        ctpDepthMarketData.setHighestPrice(CtpUtil.doubleToBigDecimal(p.getHighestPrice()));
        ctpDepthMarketData.setLowestPrice(CtpUtil.doubleToBigDecimal(p.getLowestPrice()));
        ctpDepthMarketData.setVolume(CtpUtil.doubleToBigDecimal(p.getVolume()));
        ctpDepthMarketData.setTurnover(CtpUtil.doubleToBigDecimal(p.getTurnover()));
        ctpDepthMarketData.setOpenInterest(CtpUtil.doubleToBigDecimal(p.getOpenInterest()));
        ctpDepthMarketData.setClosePrice(CtpUtil.doubleToBigDecimal(p.getClosePrice()));
        ctpDepthMarketData.setSettlementPrice(CtpUtil.doubleToBigDecimal(p.getSettlementPrice()));
        ctpDepthMarketData.setUpperLimitPrice(CtpUtil.doubleToBigDecimal(p.getUpperLimitPrice()));
        ctpDepthMarketData.setLowerLimitPrice(CtpUtil.doubleToBigDecimal(p.getLowerLimitPrice()));
        ctpDepthMarketData.setPreDelta(CtpUtil.doubleToBigDecimal(p.getPreDelta()));
        ctpDepthMarketData.setCurrDelta(CtpUtil.doubleToBigDecimal(p.getCurrDelta()));
        ctpDepthMarketData.setUpdateTime(p.getUpdateTime());
        ctpDepthMarketData.setUpdateMilliSec(CtpUtil.doubleToBigDecimal(p.getUpdateMillisec()));
        ctpDepthMarketData.setBidPrice1(CtpUtil.doubleToBigDecimal(p.getBidPrice1()));
        ctpDepthMarketData.setBidVolume1(CtpUtil.doubleToBigDecimal(p.getBidVolume1()));
        ctpDepthMarketData.setAskPrice1(CtpUtil.doubleToBigDecimal(p.getAskPrice1()));
        ctpDepthMarketData.setAskVolume1(CtpUtil.doubleToBigDecimal(p.getAskVolume1()));
        ctpDepthMarketData.setBidPrice2(CtpUtil.doubleToBigDecimal(p.getBidPrice2()));
        ctpDepthMarketData.setBidVolume2(CtpUtil.doubleToBigDecimal(p.getBidVolume2()));
        ctpDepthMarketData.setAskPrice2(CtpUtil.doubleToBigDecimal(p.getAskPrice2()));
        ctpDepthMarketData.setAskVolume2(CtpUtil.doubleToBigDecimal(p.getAskVolume2()));
        ctpDepthMarketData.setBidPrice3(CtpUtil.doubleToBigDecimal(p.getBidPrice3()));
        ctpDepthMarketData.setBidVolume3(CtpUtil.doubleToBigDecimal(p.getBidVolume3()));
        ctpDepthMarketData.setAskPrice3(CtpUtil.doubleToBigDecimal(p.getAskPrice3()));
        ctpDepthMarketData.setAskVolume3(CtpUtil.doubleToBigDecimal(p.getAskVolume3()));
        ctpDepthMarketData.setBidPrice4(CtpUtil.doubleToBigDecimal(p.getBidPrice4()));
        ctpDepthMarketData.setBidVolume4(CtpUtil.doubleToBigDecimal(p.getBidVolume4()));
        ctpDepthMarketData.setAskPrice4(CtpUtil.doubleToBigDecimal(p.getAskPrice4()));
        ctpDepthMarketData.setAskVolume4(CtpUtil.doubleToBigDecimal(p.getAskVolume4()));
        ctpDepthMarketData.setBidPrice5(CtpUtil.doubleToBigDecimal(p.getBidPrice5()));
        ctpDepthMarketData.setBidVolume5(CtpUtil.doubleToBigDecimal(p.getBidVolume5()));
        ctpDepthMarketData.setAskPrice5(CtpUtil.doubleToBigDecimal(p.getAskPrice5()));
        ctpDepthMarketData.setAskVolume5(CtpUtil.doubleToBigDecimal(p.getAskVolume5()));
        ctpDepthMarketData.setAveragePrice(CtpUtil.doubleToBigDecimal(p.getAveragePrice()));
        ctpDepthMarketData.setActionDay(p.getActionDay());
        return ctpDepthMarketData;
    }

}