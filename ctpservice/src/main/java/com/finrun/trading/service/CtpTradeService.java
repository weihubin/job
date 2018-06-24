package com.finrun.trading.service;

/**
 * Created by weihubin on 2018-04-04.
 */
public interface CtpTradeService {
    /**
     * 发送交易请求
     * @param sendMsg
     */
    void sendCtpTrade(String sendMsg);
}
