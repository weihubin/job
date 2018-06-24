package com.finrun.trading.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.finrun.trading.common.model.ctp.CThostFtdcInvestorPositionField;
import com.finrun.trading.common.utils.CtpUtil;

public class CtpInvestorPos implements Serializable{

    @JSONField (name = "instrumentId", ordinal = 1)
    private String instrumentId;

    @JSONField (name = "brokerId", ordinal = 2)
    private String brokerId;

    @JSONField (name = "investorId", ordinal = 3)
    private String investorId;

    @JSONField (name = "posiDirection", ordinal = 4)
    private String posiDirection;

    @JSONField (name = "hedgeFlag", ordinal = 5)
    private String hedgeFlag;

    @JSONField (name = "positionDate", ordinal = 6)
    private String positionDate;

    @JSONField (name = "ydPosition", ordinal = 7)
    private BigDecimal ydPosition;

    @JSONField (name = "position", ordinal = 8)
    private BigDecimal position;

    @JSONField (name = "longFrozen", ordinal = 9)
    private BigDecimal longFrozen;

    @JSONField (name = "shortFrozen", ordinal = 10)
    private BigDecimal shortFrozen;

    @JSONField (name = "longFrozenAmount", ordinal = 11)
    private BigDecimal longFrozenAmount;

    @JSONField (name = "shortFrozenAmount", ordinal = 12)
    private BigDecimal shortFrozenAmount;

    @JSONField (name = "openVolume", ordinal = 13)
    private BigDecimal openVolume;

    @JSONField (name = "closeVolume", ordinal = 14)
    private BigDecimal closeVolume;

    @JSONField (name = "openAmount", ordinal = 15)
    private BigDecimal openAmount;

    @JSONField (name = "closeAmount", ordinal = 16)
    private BigDecimal closeAmount;

    @JSONField (name = "positionCost", ordinal = 17)
    private BigDecimal positionCost;

    @JSONField (name = "preMargin", ordinal = 18)
    private BigDecimal preMargin;

    @JSONField (name = "useMargin", ordinal = 19)
    private BigDecimal useMargin;

    @JSONField (name = "frozenMargin", ordinal = 20)
    private BigDecimal frozenMargin;

    @JSONField (name = "frozenCash", ordinal = 21)
    private BigDecimal frozenCash;

    @JSONField (name = "frozenCommission", ordinal = 22)
    private BigDecimal frozenCommission;

    @JSONField (name = "cashIn", ordinal = 23)
    private BigDecimal cashIn;

    @JSONField (name = "commission", ordinal = 24)
    private BigDecimal commission;

    @JSONField (name = "closeProfit", ordinal = 25)
    private BigDecimal closeProfit;

    @JSONField (name = "positionProfit", ordinal = 26)
    private BigDecimal positionProfit;

    @JSONField (name = "preSettlementPrice", ordinal = 27)
    private BigDecimal preSettlementPrice;

    @JSONField (name = "settlementPrice", ordinal = 28)
    private BigDecimal settlementPrice;

    @JSONField (name = "tradingDay", ordinal = 29)
    private String tradingDay;

    @JSONField (name = "settlementId", ordinal = 30)
    private BigDecimal settlementId;

    @JSONField (name = "openCost", ordinal = 31)
    private BigDecimal openCost;

    @JSONField (name = "exchangeMargin", ordinal = 32)
    private BigDecimal exchangeMargin;

    @JSONField (name = "combPosition", ordinal = 33)
    private BigDecimal combPosition;

    @JSONField (name = "combLongFrozen", ordinal = 34)
    private BigDecimal combLongFrozen;

    @JSONField (name = "combShortFrozen", ordinal = 35)
    private BigDecimal combShortFrozen;

    @JSONField (name = "closeProfitByDate", ordinal = 36)
    private BigDecimal closeProfitByDate;

    @JSONField (name = "closeProfitByTrade", ordinal = 37)
    private BigDecimal closeProfitByTrade;

    @JSONField (name = "todayPosition", ordinal = 38)
    private BigDecimal todayPosition;

    @JSONField (name = "marginRateByMoney", ordinal = 39)
    private BigDecimal marginRateByMoney;

    @JSONField (name = "marginRateByVolume", ordinal = 40)
    private BigDecimal marginRateByVolume;

    @JSONField (name = "strikeFrozen", ordinal = 41)
    private BigDecimal strikeFrozen;

    @JSONField (name = "strikeFrozenAmount", ordinal = 42)
    private BigDecimal strikeFrozenAmount;

    @JSONField (name = "abandonFrozen", ordinal = 43)
    private BigDecimal abandonFrozen;

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

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

    public String getPosiDirection() {
        return posiDirection;
    }

    public void setPosiDirection(String posiDirection) {
        this.posiDirection = posiDirection;
    }

    public String getHedgeFlag() {
        return hedgeFlag;
    }

    public void setHedgeFlag(String hedgeFlag) {
        this.hedgeFlag = hedgeFlag;
    }

    public String getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(String positionDate) {
        this.positionDate = positionDate;
    }

    public BigDecimal getYdPosition() {
        return ydPosition;
    }

    public void setYdPosition(BigDecimal ydPosition) {
        this.ydPosition = ydPosition;
    }

    public BigDecimal getPosition() {
        return position;
    }

    public void setPosition(BigDecimal position) {
        this.position = position;
    }

    public BigDecimal getLongFrozen() {
        return longFrozen;
    }

    public void setLongFrozen(BigDecimal longFrozen) {
        this.longFrozen = longFrozen;
    }

    public BigDecimal getShortFrozen() {
        return shortFrozen;
    }

    public void setShortFrozen(BigDecimal shortFrozen) {
        this.shortFrozen = shortFrozen;
    }

    public BigDecimal getLongFrozenAmount() {
        return longFrozenAmount;
    }

    public void setLongFrozenAmount(BigDecimal longFrozenAmount) {
        this.longFrozenAmount = longFrozenAmount;
    }

    public BigDecimal getShortFrozenAmount() {
        return shortFrozenAmount;
    }

    public void setShortFrozenAmount(BigDecimal shortFrozenAmount) {
        this.shortFrozenAmount = shortFrozenAmount;
    }

    public BigDecimal getOpenVolume() {
        return openVolume;
    }

    public void setOpenVolume(BigDecimal openVolume) {
        this.openVolume = openVolume;
    }

    public BigDecimal getCloseVolume() {
        return closeVolume;
    }

    public void setCloseVolume(BigDecimal closeVolume) {
        this.closeVolume = closeVolume;
    }

    public BigDecimal getOpenAmount() {
        return openAmount;
    }

    public void setOpenAmount(BigDecimal openAmount) {
        this.openAmount = openAmount;
    }

    public BigDecimal getCloseAmount() {
        return closeAmount;
    }

    public void setCloseAmount(BigDecimal closeAmount) {
        this.closeAmount = closeAmount;
    }

    public BigDecimal getPositionCost() {
        return positionCost;
    }

    public void setPositionCost(BigDecimal positionCost) {
        this.positionCost = positionCost;
    }

    public BigDecimal getPreMargin() {
        return preMargin;
    }

    public void setPreMargin(BigDecimal preMargin) {
        this.preMargin = preMargin;
    }

    public BigDecimal getUseMargin() {
        return useMargin;
    }

    public void setUseMargin(BigDecimal useMargin) {
        this.useMargin = useMargin;
    }

    public BigDecimal getFrozenMargin() {
        return frozenMargin;
    }

    public void setFrozenMargin(BigDecimal frozenMargin) {
        this.frozenMargin = frozenMargin;
    }

    public BigDecimal getFrozenCash() {
        return frozenCash;
    }

    public void setFrozenCash(BigDecimal frozenCash) {
        this.frozenCash = frozenCash;
    }

    public BigDecimal getFrozenCommission() {
        return frozenCommission;
    }

    public void setFrozenCommission(BigDecimal frozenCommission) {
        this.frozenCommission = frozenCommission;
    }

    public BigDecimal getCashIn() {
        return cashIn;
    }

    public void setCashIn(BigDecimal cashIn) {
        this.cashIn = cashIn;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getCloseProfit() {
        return closeProfit;
    }

    public void setCloseProfit(BigDecimal closeProfit) {
        this.closeProfit = closeProfit;
    }

    public BigDecimal getPositionProfit() {
        return positionProfit;
    }

    public void setPositionProfit(BigDecimal positionProfit) {
        this.positionProfit = positionProfit;
    }

    public BigDecimal getPreSettlementPrice() {
        return preSettlementPrice;
    }

    public void setPreSettlementPrice(BigDecimal preSettlementPrice) {
        this.preSettlementPrice = preSettlementPrice;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
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

    public BigDecimal getOpenCost() {
        return openCost;
    }

    public void setOpenCost(BigDecimal openCost) {
        this.openCost = openCost;
    }

    public BigDecimal getExchangeMargin() {
        return exchangeMargin;
    }

    public void setExchangeMargin(BigDecimal exchangeMargin) {
        this.exchangeMargin = exchangeMargin;
    }

    public BigDecimal getCombPosition() {
        return combPosition;
    }

    public void setCombPosition(BigDecimal combPosition) {
        this.combPosition = combPosition;
    }

    public BigDecimal getCombLongFrozen() {
        return combLongFrozen;
    }

    public void setCombLongFrozen(BigDecimal combLongFrozen) {
        this.combLongFrozen = combLongFrozen;
    }

    public BigDecimal getCombShortFrozen() {
        return combShortFrozen;
    }

    public void setCombShortFrozen(BigDecimal combShortFrozen) {
        this.combShortFrozen = combShortFrozen;
    }

    public BigDecimal getCloseProfitByDate() {
        return closeProfitByDate;
    }

    public void setCloseProfitByDate(BigDecimal closeProfitByDate) {
        this.closeProfitByDate = closeProfitByDate;
    }

    public BigDecimal getCloseProfitByTrade() {
        return closeProfitByTrade;
    }

    public void setCloseProfitByTrade(BigDecimal closeProfitByTrade) {
        this.closeProfitByTrade = closeProfitByTrade;
    }

    public BigDecimal getTodayPosition() {
        return todayPosition;
    }

    public void setTodayPosition(BigDecimal todayPosition) {
        this.todayPosition = todayPosition;
    }

    public BigDecimal getMarginRateByMoney() {
        return marginRateByMoney;
    }

    public void setMarginRateByMoney(BigDecimal marginRateByMoney) {
        this.marginRateByMoney = marginRateByMoney;
    }

    public BigDecimal getMarginRateByVolume() {
        return marginRateByVolume;
    }

    public void setMarginRateByVolume(BigDecimal marginRateByVolume) {
        this.marginRateByVolume = marginRateByVolume;
    }

    public BigDecimal getStrikeFrozen() {
        return strikeFrozen;
    }

    public void setStrikeFrozen(BigDecimal strikeFrozen) {
        this.strikeFrozen = strikeFrozen;
    }

    public BigDecimal getStrikeFrozenAmount() {
        return strikeFrozenAmount;
    }

    public void setStrikeFrozenAmount(BigDecimal strikeFrozenAmount) {
        this.strikeFrozenAmount = strikeFrozenAmount;
    }

    public BigDecimal getAbandonFrozen() {
        return abandonFrozen;
    }

    public void setAbandonFrozen(BigDecimal abandonFrozen) {
        this.abandonFrozen = abandonFrozen;
    }

    /**
     * po转换
     * @return
     */
    public static CtpInvestorPos tranInvestorPos(CThostFtdcInvestorPositionField p){
        CtpInvestorPos pos = new CtpInvestorPos();
        pos.setInstrumentId(p.getInstrumentID());
        pos.setBrokerId(p.getBrokerID());
        pos.setInvestorId(p.getInvestorID());
        pos.setPosiDirection(String.valueOf(p.getPosiDirection()));
        pos.setHedgeFlag(String.valueOf(p.getHedgeFlag()));
        pos.setPositionDate(String.valueOf(p.getPositionDate()));
        pos.setYdPosition(CtpUtil.doubleToBigDecimal(p.getYdPosition()));
        pos.setPosition(CtpUtil.doubleToBigDecimal(p.getPosition()));
        pos.setLongFrozen(CtpUtil.doubleToBigDecimal(p.getLongFrozen()));
        pos.setShortFrozen(CtpUtil.doubleToBigDecimal(p.getShortFrozen()));
        pos.setLongFrozenAmount(CtpUtil.doubleToBigDecimal(p.getLongFrozenAmount()));
        pos.setShortFrozenAmount(CtpUtil.doubleToBigDecimal(p.getShortFrozenAmount()));
        pos.setOpenVolume(CtpUtil.doubleToBigDecimal(p.getOpenVolume()));
        pos.setCloseVolume(CtpUtil.doubleToBigDecimal(p.getCloseVolume()));
        pos.setOpenAmount(CtpUtil.doubleToBigDecimal(p.getOpenAmount()));
        pos.setCloseAmount(CtpUtil.doubleToBigDecimal(p.getCloseAmount()));
        pos.setPositionCost(CtpUtil.doubleToBigDecimal(p.getPositionCost()));
        pos.setPreMargin(CtpUtil.doubleToBigDecimal(p.getPreMargin()));
        pos.setUseMargin(CtpUtil.doubleToBigDecimal(p.getUseMargin()));
        pos.setFrozenMargin(CtpUtil.doubleToBigDecimal(p.getFrozenMargin()));
        pos.setFrozenCash(CtpUtil.doubleToBigDecimal(p.getFrozenCash()));
        pos.setFrozenCommission(CtpUtil.doubleToBigDecimal(p.getFrozenCommission()));
        pos.setCashIn(CtpUtil.doubleToBigDecimal(p.getCashIn()));
        pos.setCommission(CtpUtil.doubleToBigDecimal(p.getCommission()));
        pos.setCloseProfit(CtpUtil.doubleToBigDecimal(p.getCloseProfit()));
        pos.setPositionProfit(CtpUtil.doubleToBigDecimal(p.getPositionProfit()));
        pos.setPreSettlementPrice(CtpUtil.doubleToBigDecimal(p.getPreSettlementPrice()));
        pos.setSettlementPrice(CtpUtil.doubleToBigDecimal(p.getSettlementPrice()));
        pos.setTradingDay(p.getTradingDay());
        pos.setSettlementId(CtpUtil.doubleToBigDecimal(p.getSettlementID()));
        pos.setOpenCost(CtpUtil.doubleToBigDecimal(p.getOpenCost()));
        pos.setExchangeMargin(CtpUtil.doubleToBigDecimal(p.getExchangeMargin()));
        pos.setCombPosition(CtpUtil.doubleToBigDecimal(p.getCombPosition()));
        pos.setCombLongFrozen(CtpUtil.doubleToBigDecimal(p.getCombLongFrozen()));
        pos.setCombShortFrozen(CtpUtil.doubleToBigDecimal(p.getCombShortFrozen()));
        pos.setCloseProfitByDate(CtpUtil.doubleToBigDecimal(p.getCloseProfitByDate()));
        pos.setCloseProfitByTrade(CtpUtil.doubleToBigDecimal(p.getCloseProfitByTrade()));
        pos.setTodayPosition(CtpUtil.doubleToBigDecimal(p.getTodayPosition()));
        pos.setMarginRateByMoney(CtpUtil.doubleToBigDecimal(p.getMarginRateByMoney()));
        pos.setMarginRateByVolume(CtpUtil.doubleToBigDecimal(p.getMarginRateByVolume()));
        pos.setStrikeFrozen(CtpUtil.doubleToBigDecimal(p.getStrikeFrozen()));
        pos.setStrikeFrozenAmount(CtpUtil.doubleToBigDecimal(p.getStrikeFrozenAmount()));
        pos.setAbandonFrozen(CtpUtil.doubleToBigDecimal(p.getAbandonFrozen()));
        return pos;
    }

}