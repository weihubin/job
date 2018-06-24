package com.finrun.trading.service.impl;

import com.finrun.trading.common.model.ctp.CThostFtdcQryTradingAccountField;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.service.CtpTradeService;
import com.finrun.trading.service.QryTradingAccService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weihubin on 2018-04-04.
 */
@Service
public class QryTradingAccServiceImpl extends CtpTradeCtlAbstract implements QryTradingAccService, CtpTradeService {

    private static Logger LOGGER = LoggerFactory.getLogger(QryTradingAccServiceImpl.class);

    @Override
    public ResultDto qryTradingAcc(String msg) throws Exception {
        setCtpTradeService(this);
        return ctpTradeCtl(msg);
    }


    @Override
    public void sendCtpTrade(String sendMsg) {
        LOGGER.info("QryTradingAccServiceImpl, sendMsg={}", sendMsg);
        CThostFtdcQryTradingAccountField pQryTradingAccount = new CThostFtdcQryTradingAccountField();
        pQryTradingAccount.setBrokerID(ctpBrokerID);
        pQryTradingAccount.setInvestorID(ctpUserID);
        trade.reqQryTradingAccount(pQryTradingAccount, new AtomicInteger().getAndIncrement(), ctpUserID);
    }


}
