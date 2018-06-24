package com.finrun.trading.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.finrun.trading.common.model.ctp.CThostFtdcInstrumentField;
import com.finrun.trading.common.utils.CtpUtil;

public class CtpInstrumentInfo implements Serializable{

    @JSONField (name = "instrumentId", ordinal = 1)
    private String instrumentId;

    @JSONField (name = "exchangeId", ordinal = 2)
    private String exchangeId;

    @JSONField (name = "instrumentName", ordinal = 3)
    private String instrumentName;

    @JSONField (name = "exchangeInstId", ordinal = 4)
    private String exchangeInstId;

    @JSONField (name = "productId", ordinal = 5)
    private String productId;

    @JSONField (name = "productClass", ordinal = 6)
    private String productClass;

    @JSONField (name = "deliveryYear", ordinal = 7)
    private String deliveryYear;

    @JSONField (name = "deliveryMonth", ordinal = 8)
    private String deliveryMonth;

    @JSONField (name = "maxMarketOrderVolume", ordinal = 9)
    private BigDecimal maxMarketOrderVolume;

    @JSONField (name = "minMarketOrderVolume", ordinal = 10)
    private BigDecimal minMarketOrderVolume;

    @JSONField (name = "maxLimitOrderVolume", ordinal = 11)
    private BigDecimal maxLimitOrderVolume;

    @JSONField (name = "minLimitOrderVolume", ordinal = 12)
    private BigDecimal minLimitOrderVolume;

    @JSONField (name = "volumeMultiple", ordinal = 13)
    private BigDecimal volumeMultiple;

    @JSONField (name = "priceTick", ordinal = 14)
    private BigDecimal priceTick;

    @JSONField (name = "createDate", ordinal = 15)
    private String createDate;

    @JSONField (name = "openDate", ordinal = 16)
    private String openDate;

    @JSONField (name = "expireDate", ordinal = 17)
    private String expireDate;

    @JSONField (name = "startDelivDate", ordinal = 18)
    private String startDelivDate;

    @JSONField (name = "endDelivDate", ordinal = 19)
    private String endDelivDate;

    @JSONField (name = "instLifePhase", ordinal = 20)
    private String instLifePhase;

    @JSONField (name = "isTrading", ordinal = 21)
    private BigDecimal isTrading;

    @JSONField (name = "positionType", ordinal = 22)
    private String positionType;

    @JSONField (name = "positionDateType", ordinal = 23)
    private String positionDateType;

    @JSONField (name = "longMarginRatio", ordinal = 24)
    private BigDecimal longMarginRatio;

    @JSONField (name = "shortMarginRatio", ordinal = 25)
    private BigDecimal shortMarginRatio;

    @JSONField (name = "maxMarginSideAlgorithm", ordinal = 26)
    private String maxMarginSideAlgorithm;

    @JSONField (name = "underlyingInstrId", ordinal = 27)
    private String underlyingInstrId;

    @JSONField (name = "strikePrice", ordinal = 28)
    private BigDecimal strikePrice;

    @JSONField (name = "optionsType", ordinal = 29)
    private String optionsType;

    @JSONField (name = "underlyingMultiple", ordinal = 30)
    private BigDecimal underlyingMultiple;

    @JSONField (name = "combinationType", ordinal = 31)
    private String combinationType;

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

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getExchangeInstId() {
        return exchangeInstId;
    }

    public void setExchangeInstId(String exchangeInstId) {
        this.exchangeInstId = exchangeInstId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getDeliveryYear() {
        return deliveryYear;
    }

    public void setDeliveryYear(String deliveryYear) {
        this.deliveryYear = deliveryYear;
    }

    public String getDeliveryMonth() {
        return deliveryMonth;
    }

    public void setDeliveryMonth(String deliveryMonth) {
        this.deliveryMonth = deliveryMonth;
    }

    public BigDecimal getMaxMarketOrderVolume() {
        return maxMarketOrderVolume;
    }

    public void setMaxMarketOrderVolume(BigDecimal maxMarketOrderVolume) {
        this.maxMarketOrderVolume = maxMarketOrderVolume;
    }

    public BigDecimal getMinMarketOrderVolume() {
        return minMarketOrderVolume;
    }

    public void setMinMarketOrderVolume(BigDecimal minMarketOrderVolume) {
        this.minMarketOrderVolume = minMarketOrderVolume;
    }

    public BigDecimal getMaxLimitOrderVolume() {
        return maxLimitOrderVolume;
    }

    public void setMaxLimitOrderVolume(BigDecimal maxLimitOrderVolume) {
        this.maxLimitOrderVolume = maxLimitOrderVolume;
    }

    public BigDecimal getMinLimitOrderVolume() {
        return minLimitOrderVolume;
    }

    public void setMinLimitOrderVolume(BigDecimal minLimitOrderVolume) {
        this.minLimitOrderVolume = minLimitOrderVolume;
    }

    public BigDecimal getVolumeMultiple() {
        return volumeMultiple;
    }

    public void setVolumeMultiple(BigDecimal volumeMultiple) {
        this.volumeMultiple = volumeMultiple;
    }

    public BigDecimal getPriceTick() {
        return priceTick;
    }

    public void setPriceTick(BigDecimal priceTick) {
        this.priceTick = priceTick;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getStartDelivDate() {
        return startDelivDate;
    }

    public void setStartDelivDate(String startDelivDate) {
        this.startDelivDate = startDelivDate;
    }

    public String getEndDelivDate() {
        return endDelivDate;
    }

    public void setEndDelivDate(String endDelivDate) {
        this.endDelivDate = endDelivDate;
    }

    public String getInstLifePhase() {
        return instLifePhase;
    }

    public void setInstLifePhase(String instLifePhase) {
        this.instLifePhase = instLifePhase;
    }

    public BigDecimal getIsTrading() {
        return isTrading;
    }

    public void setIsTrading(BigDecimal isTrading) {
        this.isTrading = isTrading;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getPositionDateType() {
        return positionDateType;
    }

    public void setPositionDateType(String positionDateType) {
        this.positionDateType = positionDateType;
    }

    public BigDecimal getLongMarginRatio() {
        return longMarginRatio;
    }

    public void setLongMarginRatio(BigDecimal longMarginRatio) {
        this.longMarginRatio = longMarginRatio;
    }

    public BigDecimal getShortMarginRatio() {
        return shortMarginRatio;
    }

    public void setShortMarginRatio(BigDecimal shortMarginRatio) {
        this.shortMarginRatio = shortMarginRatio;
    }

    public String getMaxMarginSideAlgorithm() {
        return maxMarginSideAlgorithm;
    }

    public void setMaxMarginSideAlgorithm(String maxMarginSideAlgorithm) {
        this.maxMarginSideAlgorithm = maxMarginSideAlgorithm;
    }

    public String getUnderlyingInstrId() {
        return underlyingInstrId;
    }

    public void setUnderlyingInstrId(String underlyingInstrId) {
        this.underlyingInstrId = underlyingInstrId;
    }

    public BigDecimal getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(BigDecimal strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getOptionsType() {
        return optionsType;
    }

    public void setOptionsType(String optionsType) {
        this.optionsType = optionsType;
    }

    public BigDecimal getUnderlyingMultiple() {
        return underlyingMultiple;
    }

    public void setUnderlyingMultiple(BigDecimal underlyingMultiple) {
        this.underlyingMultiple = underlyingMultiple;
    }

    public String getCombinationType() {
        return combinationType;
    }

    public void setCombinationType(String combinationType) {
        this.combinationType = combinationType;
    }



    public static CtpInstrumentInfo transInstrumentInfo(CThostFtdcInstrumentField p){
        CtpInstrumentInfo info = new CtpInstrumentInfo();
        info.setInstrumentId(p.getInstrumentID());
        info.setExchangeId(p.getExchangeID());
        info.setInstrumentName(p.getInstrumentName());
        info.setExchangeInstId(p.getExchangeInstID());
        info.setProductId(p.getProductID());
        info.setProductClass(String.valueOf(p.getProductClass()));
        info.setDeliveryYear(String.valueOf(p.getDeliveryYear()));
        info.setDeliveryMonth(String.valueOf(p.getDeliveryMonth()));
        info.setMaxMarketOrderVolume(CtpUtil.doubleToBigDecimal(p.getMaxMarketOrderVolume()));
        info.setMinMarketOrderVolume(CtpUtil.doubleToBigDecimal(p.getMinMarketOrderVolume()));
        info.setMaxLimitOrderVolume(CtpUtil.doubleToBigDecimal(p.getMaxLimitOrderVolume()));
        info.setMinLimitOrderVolume(CtpUtil.doubleToBigDecimal(p.getMinLimitOrderVolume()));
        info.setVolumeMultiple(CtpUtil.doubleToBigDecimal(p.getVolumeMultiple()));
        info.setPriceTick(CtpUtil.doubleToBigDecimal(p.getPriceTick()));
        info.setCreateDate(String.valueOf(p.getCreateDate()));
        info.setOpenDate(String.valueOf(p.getOpenDate()));
        info.setExpireDate(String.valueOf(p.getExpireDate()));
        info.setStartDelivDate(String.valueOf(p.getStartDelivDate()));
        info.setEndDelivDate(String.valueOf(p.getEndDelivDate()));
        info.setInstLifePhase(String.valueOf(p.getInstLifePhase()));
        info.setIsTrading(CtpUtil.doubleToBigDecimal(p.getIsTrading()));
        info.setPositionType(String.valueOf(p.getPositionType()));
        info.setPositionDateType(String.valueOf(p.getPositionDateType()));
        info.setLongMarginRatio(CtpUtil.doubleToBigDecimal(p.getLongMarginRatio()));
        info.setShortMarginRatio(CtpUtil.doubleToBigDecimal(p.getShortMarginRatio()));
        info.setMaxMarginSideAlgorithm(String.valueOf(p.getMaxMarginSideAlgorithm()));
        info.setUnderlyingInstrId(String.valueOf(p.getUnderlyingInstrID()));
        info.setStrikePrice(CtpUtil.doubleToBigDecimal(p.getStrikePrice()));
        info.setOptionsType(String.valueOf(p.getOptionsType()));
        info.setUnderlyingMultiple(CtpUtil.doubleToBigDecimal(p.getUnderlyingMultiple()));
        info.setCombinationType(String.valueOf(p.getCombinationType()));
        return info;
    }


    @Override
    public String toString() {
        return "CtpInstrumentInfo{" +
                "instrumentId='" + instrumentId + '\'' +
                ", exchangeId='" + exchangeId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", exchangeInstId='" + exchangeInstId + '\'' +
                ", productId='" + productId + '\'' +
                ", productClass='" + productClass + '\'' +
                ", deliveryYear='" + deliveryYear + '\'' +
                ", deliveryMonth='" + deliveryMonth + '\'' +
                ", maxMarketOrderVolume=" + maxMarketOrderVolume +
                ", minMarketOrderVolume=" + minMarketOrderVolume +
                ", maxLimitOrderVolume=" + maxLimitOrderVolume +
                ", minLimitOrderVolume=" + minLimitOrderVolume +
                ", volumeMultiple=" + volumeMultiple +
                ", priceTick=" + priceTick +
                ", createDate='" + createDate + '\'' +
                ", openDate='" + openDate + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", startDelivDate='" + startDelivDate + '\'' +
                ", endDelivDate='" + endDelivDate + '\'' +
                ", instLifePhase='" + instLifePhase + '\'' +
                ", isTrading=" + isTrading +
                ", positionType='" + positionType + '\'' +
                ", positionDateType='" + positionDateType + '\'' +
                ", longMarginRatio=" + longMarginRatio +
                ", shortMarginRatio=" + shortMarginRatio +
                ", maxMarginSideAlgorithm='" + maxMarginSideAlgorithm + '\'' +
                ", underlyingInstrId='" + underlyingInstrId + '\'' +
                ", strikePrice=" + strikePrice +
                ", optionsType='" + optionsType + '\'' +
                ", underlyingMultiple=" + underlyingMultiple +
                ", combinationType='" + combinationType + '\'' +
                '}';
    }
}