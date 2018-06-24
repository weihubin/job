package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.model.ctp.CThostFtdcQryOrderField;
import com.finrun.trading.common.model.ctp.CThostFtdcQryTradeField;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.CtpTradeService;
import com.finrun.trading.service.ReqQryTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weihubin on 2018-04-04.
 */
@Service
public class ReqQryTradeServiceImpl extends CtpTradeCtlAbstract implements ReqQryTradeService, CtpTradeService {

    private static Logger LOGGER = LoggerFactory.getLogger(ReqQryTradeServiceImpl.class);

    @Override
    public ResultDto reqQryTrade(String msg) throws Exception {
        setCtpTradeService(this);
        return ctpTradeCtl(msg);
    }

    @Override
    public void sendCtpTrade(String sendMsg) {
        LOGGER.info("ReqQryTradeServiceImpl, sendMsg={}", sendMsg);
        //instrumentID、tradeID
        JSONObject jsonObject = JSON.parseObject(sendMsg);
        CThostFtdcQryTradeField pQryTrade = jsonObject.toJavaObject(CThostFtdcQryTradeField.class);
        pQryTrade.setBrokerID(ctpBrokerID);
        pQryTrade.setInvestorID(ctpUserID);
        trade.reqQryTrade(pQryTrade, new AtomicInteger().getAndIncrement(), ctpUserID);
    }
}
