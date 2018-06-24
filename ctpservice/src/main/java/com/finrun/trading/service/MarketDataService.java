package com.finrun.trading.service;


import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-03-28.
 */
public interface MarketDataService {
    /**
     * 合约行情信息
     * @param ppInstrumentID  合约ID
     * @return
     */
    ResultDto subscribeMarketData(String ppInstrumentID[]) throws Exception;
}
