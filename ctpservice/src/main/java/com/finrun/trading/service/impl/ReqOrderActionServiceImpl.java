package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.model.ctp.CThostFtdcInputOrderActionField;
import com.finrun.trading.common.model.ctp.CThostFtdcRspUserLoginField;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.CtpUtil;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.CtpTradeService;
import com.finrun.trading.service.ReqOrderActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by weihubin on 2018-05-15.
 */
@Service
public class ReqOrderActionServiceImpl extends CtpTradeCtlAbstract implements ReqOrderActionService, CtpTradeService {

    private static Logger LOGGER = LoggerFactory.getLogger(ReqOrderActionServiceImpl.class);

    /**
     * 和报单响应和回报相似。
     Thost 收到撤单指令，如果没有通过参数校验，拒绝接受撤单指令。用户就会收到
     OnRspOrderAction 消息，其中包含了错误编码和错误消息。
     如果 Thost 接受了撤单指令，用户不会收到 OnRspOrderAction，而会收到
     OnRtnOrder，用来更新委托状态。
     交易所收到撤单后，通过校验，执行了撤单操作。用户会收到 OnRtnOrder。
     如果交易所认为报单错误，用户就会收到 OnErrRtnOrderAction。
     * @param msg
     * @return
     * @throws Exception
     */
    @Override
    public ResultDto reqOrderAction(String msg) throws Exception {
        setCtpTradeService(this);
        return ctpTradeCtl(msg);
    }

    @Override
    public void sendCtpTrade(String sendMsg) {
        LOGGER.info("ReqOrderActionServiceImpl, sendMsg={}", sendMsg);
        CThostFtdcInputOrderActionField pInputOrderAction = JSON.parseObject(sendMsg, CThostFtdcInputOrderActionField.class);
        //报单requestID、报单引用orderRef 不能重复
        pInputOrderAction.setBrokerID(ctpBrokerID);
        pInputOrderAction.setUserID(ctpUserID);
        pInputOrderAction.setInvestorID(ctpUserID);

        CThostFtdcRspUserLoginField userLoginField = trade.getUserSession(ctpUserID);
        //考虑到ctp前置通过session、frontId、maxOrderRef防重，每次请求+1
        int maxOrderRef = CtpUtil.getMaxOrderRef(userLoginField);
        pInputOrderAction.setRequestID(maxOrderRef);
        // 报单引用
        pInputOrderAction.setOrderActionRef(maxOrderRef);

        trade.reqOrderAction(pInputOrderAction, pInputOrderAction.getRequestID(), ctpUserID);
    }
}
