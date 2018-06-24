package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.model.ctp.CThostFtdcQryOrderField;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.CtpTradeService;
import com.finrun.trading.service.ReqQryOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weihubin on 2018-05-22.
 */
@Service
public class ReqQryOrderServiceImpl extends CtpTradeCtlAbstract implements ReqQryOrderService, CtpTradeService {

    private static Logger LOGGER = LoggerFactory.getLogger(ReqQryOrderServiceImpl.class);

    @Override
    public ResultDto reqQryOrder(String msg) throws Exception {
        setCtpTradeService(this);
        return ctpTradeCtl(msg);
    }

    @Override
    public void sendCtpTrade(String sendMsg) {
        LOGGER.info("ReqQryTradeServiceImpl, sendMsg={}", sendMsg);
        JSONObject jsonObject = JSON.parseObject(sendMsg);
        CThostFtdcQryOrderField pQryOrder = jsonObject.toJavaObject(CThostFtdcQryOrderField.class);
        pQryOrder.setBrokerID(ctpBrokerID);
        pQryOrder.setInvestorID(ctpUserID);
        trade.reqQryOrder(pQryOrder, new AtomicInteger().getAndIncrement(), ctpUserID);
    }

}
