package com.finrun.trading.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.finrun.trading.common.model.ctp.CThostFtdcTradingAccountField;
import com.finrun.trading.common.utils.CtpUtil;

public class CtpTradingAccount implements Serializable{

    @JSONField (name = "brokerId", ordinal = 1)
    private String brokerId;

    @JSONField (name = "accountId", ordinal = 2)
    private String accountId;

    @JSONField (name = "preMortgage", ordinal = 3)
    private BigDecimal preMortgage;

    @JSONField (name = "preCredit", ordinal = 4)
    private BigDecimal preCredit;

    @JSONField (name = "preDeposit", ordinal = 5)
    private BigDecimal preDeposit;

    @JSONField (name = "preBalance", ordinal = 6)
    private BigDecimal preBalance;

    @JSONField (name = "preMargin", ordinal = 7)
    private BigDecimal preMargin;

    @JSONField (name = "interestBase", ordinal = 8)
    private BigDecimal interestBase;

    @JSONField (name = "interest", ordinal = 9)
    private BigDecimal interest;

    @JSONField (name = "deposit", ordinal = 10)
    private BigDecimal deposit;

    @JSONField (name = "withdraw", ordinal = 11)
    private BigDecimal withdraw;

    @JSONField (name = "frozenMargin", ordinal = 12)
    private BigDecimal frozenMargin;

    @JSONField (name = "frozenCash", ordinal = 13)
    private BigDecimal frozenCash;

    @JSONField (name = "frozenCommission", ordinal = 14)
    private BigDecimal frozenCommission;

    @JSONField (name = "currMargin", ordinal = 15)
    private BigDecimal currMargin;

    @JSONField (name = "cashIn", ordinal = 16)
    private BigDecimal cashIn;

    @JSONField (name = "commission", ordinal = 17)
    private BigDecimal commission;

    @JSONField (name = "closeProfit", ordinal = 18)
    private BigDecimal closeProfit;

    @JSONField (name = "positionProfit", ordinal = 19)
    private BigDecimal positionProfit;

    @JSONField (name = "balance", ordinal = 20)
    private BigDecimal balance;

    @JSONField (name = "available", ordinal = 21)
    private BigDecimal available;

    @JSONField (name = "withdrawQuota", ordinal = 22)
    private BigDecimal withdrawQuota;

    @JSONField (name = "reserve", ordinal = 23)
    private BigDecimal reserve;

    @JSONField (name = "tradingDay", ordinal = 24)
    private String tradingDay;

    @JSONField (name = "settlementId", ordinal = 25)
    private BigDecimal settlementId;

    @JSONField (name = "credit", ordinal = 26)
    private BigDecimal credit;

    @JSONField (name = "mortgage", ordinal = 27)
    private BigDecimal mortgage;

    @JSONField (name = "exchangeMargin", ordinal = 28)
    private BigDecimal exchangeMargin;

    @JSONField (name = "deliveryMargin", ordinal = 29)
    private BigDecimal deliveryMargin;

    @JSONField (name = "exchangeDeliveryMargin", ordinal = 30)
    private BigDecimal exchangeDeliveryMargin;

    @JSONField (name = "reserveBalance", ordinal = 31)
    private BigDecimal reserveBalance;

    @JSONField (name = "currencyId", ordinal = 32)
    private String currencyId;

    @JSONField (name = "preFundMortgageIn", ordinal = 33)
    private BigDecimal preFundMortgageIn;

    @JSONField (name = "preFundMortgageOut", ordinal = 34)
    private BigDecimal preFundMortgageOut;

    @JSONField (name = "fundMortgageIn", ordinal = 35)
    private BigDecimal fundMortgageIn;

    @JSONField (name = "fundMortgageOut", ordinal = 36)
    private BigDecimal fundMortgageOut;

    @JSONField (name = "fundMortgageAvailable", ordinal = 37)
    private BigDecimal fundMortgageAvailable;

    @JSONField (name = "mortgageableFund", ordinal = 38)
    private BigDecimal mortgageableFund;

    @JSONField (name = "specProdMargin", ordinal = 39)
    private BigDecimal specProdMargin;

    @JSONField (name = "specProdFrozenMargin", ordinal = 40)
    private BigDecimal specProdFrozenMargin;

    @JSONField (name = "specProdCommission", ordinal = 41)
    private BigDecimal specProdCommission;

    @JSONField (name = "specProdFrozenCommission", ordinal = 42)
    private BigDecimal specProdFrozenCommission;

    @JSONField (name = "specProdPositionProfit", ordinal = 43)
    private BigDecimal specProdPositionProfit;

    @JSONField (name = "specProdCloseProfit", ordinal = 44)
    private BigDecimal specProdCloseProfit;

    @JSONField (name = "specProdPositionProfitbyalg", ordinal = 45)
    private BigDecimal specProdPositionProfitbyalg;

    @JSONField (name = "specProdExchangeMargin", ordinal = 46)
    private BigDecimal specProdExchangeMargin;

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getPreMortgage() {
        return preMortgage;
    }

    public void setPreMortgage(BigDecimal preMortgage) {
        this.preMortgage = preMortgage;
    }

    public BigDecimal getPreCredit() {
        return preCredit;
    }

    public void setPreCredit(BigDecimal preCredit) {
        this.preCredit = preCredit;
    }

    public BigDecimal getPreDeposit() {
        return preDeposit;
    }

    public void setPreDeposit(BigDecimal preDeposit) {
        this.preDeposit = preDeposit;
    }

    public BigDecimal getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(BigDecimal preBalance) {
        this.preBalance = preBalance;
    }

    public BigDecimal getPreMargin() {
        return preMargin;
    }

    public void setPreMargin(BigDecimal preMargin) {
        this.preMargin = preMargin;
    }

    public BigDecimal getInterestBase() {
        return interestBase;
    }

    public void setInterestBase(BigDecimal interestBase) {
        this.interestBase = interestBase;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
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

    public BigDecimal getCurrMargin() {
        return currMargin;
    }

    public void setCurrMargin(BigDecimal currMargin) {
        this.currMargin = currMargin;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public BigDecimal getWithdrawQuota() {
        return withdrawQuota;
    }

    public void setWithdrawQuota(BigDecimal withdrawQuota) {
        this.withdrawQuota = withdrawQuota;
    }

    public BigDecimal getReserve() {
        return reserve;
    }

    public void setReserve(BigDecimal reserve) {
        this.reserve = reserve;
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

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getMortgage() {
        return mortgage;
    }

    public void setMortgage(BigDecimal mortgage) {
        this.mortgage = mortgage;
    }

    public BigDecimal getExchangeMargin() {
        return exchangeMargin;
    }

    public void setExchangeMargin(BigDecimal exchangeMargin) {
        this.exchangeMargin = exchangeMargin;
    }

    public BigDecimal getDeliveryMargin() {
        return deliveryMargin;
    }

    public void setDeliveryMargin(BigDecimal deliveryMargin) {
        this.deliveryMargin = deliveryMargin;
    }

    public BigDecimal getExchangeDeliveryMargin() {
        return exchangeDeliveryMargin;
    }

    public void setExchangeDeliveryMargin(BigDecimal exchangeDeliveryMargin) {
        this.exchangeDeliveryMargin = exchangeDeliveryMargin;
    }

    public BigDecimal getReserveBalance() {
        return reserveBalance;
    }

    public void setReserveBalance(BigDecimal reserveBalance) {
        this.reserveBalance = reserveBalance;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getPreFundMortgageIn() {
        return preFundMortgageIn;
    }

    public void setPreFundMortgageIn(BigDecimal preFundMortgageIn) {
        this.preFundMortgageIn = preFundMortgageIn;
    }

    public BigDecimal getPreFundMortgageOut() {
        return preFundMortgageOut;
    }

    public void setPreFundMortgageOut(BigDecimal preFundMortgageOut) {
        this.preFundMortgageOut = preFundMortgageOut;
    }

    public BigDecimal getFundMortgageIn() {
        return fundMortgageIn;
    }

    public void setFundMortgageIn(BigDecimal fundMortgageIn) {
        this.fundMortgageIn = fundMortgageIn;
    }

    public BigDecimal getFundMortgageOut() {
        return fundMortgageOut;
    }

    public void setFundMortgageOut(BigDecimal fundMortgageOut) {
        this.fundMortgageOut = fundMortgageOut;
    }

    public BigDecimal getFundMortgageAvailable() {
        return fundMortgageAvailable;
    }

    public void setFundMortgageAvailable(BigDecimal fundMortgageAvailable) {
        this.fundMortgageAvailable = fundMortgageAvailable;
    }

    public BigDecimal getMortgageableFund() {
        return mortgageableFund;
    }

    public void setMortgageableFund(BigDecimal mortgageableFund) {
        this.mortgageableFund = mortgageableFund;
    }

    public BigDecimal getSpecProdMargin() {
        return specProdMargin;
    }

    public void setSpecProdMargin(BigDecimal specProdMargin) {
        this.specProdMargin = specProdMargin;
    }

    public BigDecimal getSpecProdFrozenMargin() {
        return specProdFrozenMargin;
    }

    public void setSpecProdFrozenMargin(BigDecimal specProdFrozenMargin) {
        this.specProdFrozenMargin = specProdFrozenMargin;
    }

    public BigDecimal getSpecProdCommission() {
        return specProdCommission;
    }

    public void setSpecProdCommission(BigDecimal specProdCommission) {
        this.specProdCommission = specProdCommission;
    }

    public BigDecimal getSpecProdFrozenCommission() {
        return specProdFrozenCommission;
    }

    public void setSpecProdFrozenCommission(BigDecimal specProdFrozenCommission) {
        this.specProdFrozenCommission = specProdFrozenCommission;
    }

    public BigDecimal getSpecProdPositionProfit() {
        return specProdPositionProfit;
    }

    public void setSpecProdPositionProfit(BigDecimal specProdPositionProfit) {
        this.specProdPositionProfit = specProdPositionProfit;
    }

    public BigDecimal getSpecProdCloseProfit() {
        return specProdCloseProfit;
    }

    public void setSpecProdCloseProfit(BigDecimal specProdCloseProfit) {
        this.specProdCloseProfit = specProdCloseProfit;
    }

    public BigDecimal getSpecProdPositionProfitbyalg() {
        return specProdPositionProfitbyalg;
    }

    public void setSpecProdPositionProfitbyalg(BigDecimal specProdPositionProfitbyalg) {
        this.specProdPositionProfitbyalg = specProdPositionProfitbyalg;
    }

    public BigDecimal getSpecProdExchangeMargin() {
        return specProdExchangeMargin;
    }

    public void setSpecProdExchangeMargin(BigDecimal specProdExchangeMargin) {
        this.specProdExchangeMargin = specProdExchangeMargin;
    }

    /**
     * po转换
     * @param p
     * @return
     */
    public static CtpTradingAccount transTradingAccount(CThostFtdcTradingAccountField p){
        CtpTradingAccount acc = new CtpTradingAccount();
        acc.setBrokerId(p.getBrokerID());
        acc.setAccountId(p.getAccountID());
        acc.setPreMortgage(CtpUtil.doubleToBigDecimal(p.getPreMortgage()));
        acc.setPreCredit(CtpUtil.doubleToBigDecimal(p.getPreCredit()));
        acc.setPreDeposit(CtpUtil.doubleToBigDecimal(p.getPreDeposit()));
        acc.setPreBalance(CtpUtil.doubleToBigDecimal(p.getPreBalance()));
        acc.setPreMargin(CtpUtil.doubleToBigDecimal(p.getPreMargin()));
        acc.setInterestBase(CtpUtil.doubleToBigDecimal(p.getInterestBase()));
        acc.setInterest(CtpUtil.doubleToBigDecimal(p.getInterest()));
        acc.setDeposit(CtpUtil.doubleToBigDecimal(p.getDeposit()));
        acc.setWithdraw(CtpUtil.doubleToBigDecimal(p.getWithdraw()));
        acc.setFrozenMargin(CtpUtil.doubleToBigDecimal(p.getFrozenMargin()));
        acc.setFrozenCash(CtpUtil.doubleToBigDecimal(p.getFrozenCash()));
        acc.setFrozenCommission(CtpUtil.doubleToBigDecimal(p.getFrozenCommission()));
        acc.setCurrMargin(CtpUtil.doubleToBigDecimal(p.getCurrMargin()));
        acc.setCashIn(CtpUtil.doubleToBigDecimal(p.getCashIn()));
        acc.setCommission(CtpUtil.doubleToBigDecimal(p.getCommission()));
        acc.setCloseProfit(CtpUtil.doubleToBigDecimal(p.getCloseProfit()));
        acc.setPositionProfit(CtpUtil.doubleToBigDecimal(p.getPositionProfit()));
        acc.setBalance(CtpUtil.doubleToBigDecimal(p.getBalance()));
        acc.setAvailable(CtpUtil.doubleToBigDecimal(p.getAvailable()));
        acc.setWithdrawQuota(CtpUtil.doubleToBigDecimal(p.getWithdrawQuota()));
        acc.setReserve(CtpUtil.doubleToBigDecimal(p.getReserve()));
        acc.setTradingDay(p.getTradingDay());
        acc.setSettlementId(CtpUtil.doubleToBigDecimal(p.getSettlementID()));
        acc.setCredit(CtpUtil.doubleToBigDecimal(p.getCredit()));
        acc.setMortgage(CtpUtil.doubleToBigDecimal(p.getMortgage()));
        acc.setExchangeMargin(CtpUtil.doubleToBigDecimal(p.getExchangeMargin()));
        acc.setDeliveryMargin(CtpUtil.doubleToBigDecimal(p.getDeliveryMargin()));
        acc.setExchangeDeliveryMargin(CtpUtil.doubleToBigDecimal(p.getExchangeDeliveryMargin()));
        acc.setReserveBalance(CtpUtil.doubleToBigDecimal(p.getReserveBalance()));
        acc.setCurrencyId(p.getCurrencyID());
        acc.setPreFundMortgageIn(CtpUtil.doubleToBigDecimal(p.getPreFundMortgageIn()));
        acc.setPreFundMortgageOut(CtpUtil.doubleToBigDecimal(p.getPreFundMortgageOut()));
        acc.setFundMortgageIn(CtpUtil.doubleToBigDecimal(p.getFundMortgageIn()));
        acc.setFundMortgageOut(CtpUtil.doubleToBigDecimal(p.getFundMortgageOut()));
        acc.setFundMortgageAvailable(CtpUtil.doubleToBigDecimal(p.getFundMortgageAvailable()));
        acc.setMortgageableFund(CtpUtil.doubleToBigDecimal(p.getMortgageableFund()));
        acc.setSpecProdMargin(CtpUtil.doubleToBigDecimal(p.getSpecProductMargin()));
        acc.setSpecProdFrozenMargin(CtpUtil.doubleToBigDecimal(p.getSpecProductFrozenMargin()));
        acc.setSpecProdCommission(CtpUtil.doubleToBigDecimal(p.getSpecProductCommission()));
        acc.setSpecProdFrozenCommission(CtpUtil.doubleToBigDecimal(p.getSpecProductFrozenCommission()));
        acc.setSpecProdPositionProfit(CtpUtil.doubleToBigDecimal(p.getSpecProductPositionProfit()));
        acc.setSpecProdCloseProfit(CtpUtil.doubleToBigDecimal(p.getSpecProductCloseProfit()));
        acc.setSpecProdPositionProfitbyalg(CtpUtil.doubleToBigDecimal(p.getSpecProductPositionProfitByAlg()));
        acc.setSpecProdExchangeMargin(CtpUtil.doubleToBigDecimal(p.getSpecProductExchangeMargin()));
        return acc;
    }

}