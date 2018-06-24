package com.finrun.trading.common.model;

import com.finrun.trading.common.ctp.CTPTradeAdaptor;

/**
 * Created by weihubin on 2018-05-20.
 *
 * 单例模式，创建CTPTradeAdaptor实例
 *
 */
public class CtpTradeSingleton {

    private static volatile CTPTradeAdaptor trade = null;

    public static CTPTradeAdaptor getInstance(){
        if(trade == null){
            synchronized (CtpTradeSingleton.class){
                if(trade == null){
                    trade =  new CTPTradeAdaptor();
                }
            }
        }
        return trade;
    }

}
