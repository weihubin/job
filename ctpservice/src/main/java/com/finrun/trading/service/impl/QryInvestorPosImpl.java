package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSON;
import com.finrun.trading.common.model.ctp.CThostFtdcQryInvestorField;
import com.finrun.trading.common.model.ctp.CThostFtdcQryInvestorPositionField;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.CtpTradeService;
import com.finrun.trading.service.QryInvestorPosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weihubin on 2018-04-04.
 */
@Service
public class QryInvestorPosImpl extends CtpTradeCtlAbstract implements QryInvestorPosService, CtpTradeService {

    private static Logger LOGGER = LoggerFactory.getLogger(QryInvestorPosImpl.class);

    @Override
    public ResultDto qryInvestorPos(String msg) throws Exception {
        setCtpTradeService(this);
        return ctpTradeCtl(msg);
    }

    @Override
    public void sendCtpTrade(String sendMsg) {
        LOGGER.info("QryInvestorPosImpl, sendMsg={}", sendMsg);
        CThostFtdcQryInvestorPositionField pQryInvestorPosition = JSON.
                parseObject(sendMsg, CThostFtdcQryInvestorPositionField.class);
        pQryInvestorPosition.setBrokerID(ctpBrokerID);
        pQryInvestorPosition.setInvestorID(ctpUserID);
        trade.reqQryInvestorPosition(pQryInvestorPosition, new AtomicInteger().getAndIncrement(), ctpUserID);
    }
}
