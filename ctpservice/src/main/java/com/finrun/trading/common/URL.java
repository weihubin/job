package com.finrun.trading.common;

/**
 * Created by weihubin on 2018-03-28.
 */
public abstract class URL {
    /**
     * 行情订阅，查询行情信息
     */
    public static final String SUBSCRIBE_MARKET_DATA = "/subscribeMarketData";


    /**
     * 报单录入
     */
    public static final String REQ_ORDER_INSERT = "/reqOrderInsert";

    /**
     * 查询投资人持仓
     */
    public static final String REQ_QRY_INVESTOR_POS = "/qryInvestorPos";


    /**
     * 查询投资人资金账户信息
     */
    public static final String REQ_QRY_TRADING_ACC = "/qryTradingAcc";



    /**
     * 报单查询
     */
    public static final String REQ_QRY_ORDER= "/reqQryOrder";


    /**
     * 查询成交（只能查询当天的交易）
     */
    public static final String REQ_QRY_TRADE = "/reqQryTrade";


    /**
     * 请求查询合约
     */
    public static final String REQ_QRY_INSTRUMENT = "/reqQryInstrument";


    /**
     * 同步交易所所有合约
     */
    public static final String SYN_INSTRUMENTS = "/synInstruments";


    /**
     * 报单操作请求(报单的撤销、报单的修改)
     */
    public static final String REQ_ORDER_ACTION = "/reqOrderAction";



}
