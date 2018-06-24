package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.CONST;
import com.finrun.trading.common.model.ctp.CThostFtdcInputOrderField;
import com.finrun.trading.common.model.ctp.CThostFtdcRspUserLoginField;
import com.finrun.trading.common.model.ctp.CtpConstants;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.CtpUtil;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.CtpTradeService;
import com.finrun.trading.service.ReqOrderService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by weihubin on 2018-03-30.
 */
@Service
public class ReqOrderServiceImpl extends CtpTradeCtlAbstract implements ReqOrderService, CtpTradeService {

    private static Logger LOGGER = LoggerFactory.getLogger(ReqOrderServiceImpl.class);

    /**
     * Thost 收到报单指令，如果没有通过参数校验，拒绝接受报单指令。用户就会收到
     OnRspOrderInsert 消息，其中包含了错误编码和错误消息。
     如果Thost接受了报单指令，用户不会收到OnRspOrderInser，而会收到OnRtnOrder，
     用来更新委托状态。
     交易所收到报单后，通过校验。用户会收到 OnRtnOrder、OnRtnTrade。
     如果交易所认为报单错误，用户就会收到 OnErrRtnOrder。
     * @param msg
     * @return
     * @throws Exception
     */
    @Override
    public ResultDto reqOrderInsert(String msg) throws Exception {
        setCtpTradeService(this);
        return ctpTradeCtl(msg);
    }

    @Override
    public void sendCtpTrade(String sendMsg){
        LOGGER.info("ReqOrderServiceImpl, sendMsg={}", sendMsg);
        JSONObject jsonObject = JSON.parseObject(sendMsg);
        CThostFtdcInputOrderField pInputOrder = JSON.parseObject(sendMsg, CThostFtdcInputOrderField.class);
        //最小成交量：1
        pInputOrder.setMinVolume(1);
        //强平原因：非强平
        pInputOrder.setForceCloseReason(CtpConstants.THOST_FTDC_FCC_NotForceClose);
        //自动挂起标志：否
        pInputOrder.setIsAutoSuspend(0);
        //用户强评标志：否
        pInputOrder.setUserForceClose(0);
        String combHedgeFlag = pInputOrder.getCombHedgeFlag();
        if(StringUtils.isBlank(combHedgeFlag)){
            //投机
            pInputOrder.setCombHedgeFlag(String.valueOf(CtpConstants.THOST_FTDC_HF_Speculation));
        }
        //1.限价单
        if(CtpConstants.THOST_FTDC_OPT_LimitPrice == pInputOrder.getOrderPriceType()){
            pInputOrder.setLimitPrice(pInputOrder.getLimitPrice());
        }else{
            //2.市价单
            pInputOrder.setOrderPriceType(CtpConstants.THOST_FTDC_OPT_AnyPrice);
            pInputOrder.setLimitPrice(0);
        }
        //报单指令类别
        String ordInstType = jsonObject.getString("ordInstType");
        switch (ordInstType){
            case CONST.ORD_INST_TYPE_GFD:
                pInputOrder.setTimeCondition(CtpConstants.THOST_FTDC_TC_GFD);
                pInputOrder.setVolumeCondition(CtpConstants.THOST_FTDC_VC_AV);
                //触发条件:立即
                pInputOrder.setContingentCondition(CtpConstants.THOST_FTDC_CC_Immediately);
                break;
            case CONST.ORD_INST_TYPE_FAK:
                pInputOrder.setTimeCondition(CtpConstants.THOST_FTDC_TC_IOC);
                pInputOrder.setVolumeCondition(CtpConstants.THOST_FTDC_VC_AV);
                //触发条件:立即
                pInputOrder.setContingentCondition(CtpConstants.THOST_FTDC_CC_Immediately);
                break;
            case CONST.ORD_INST_TYPE_FOK:
                pInputOrder.setTimeCondition(CtpConstants.THOST_FTDC_TC_IOC);
                //全部数量
                pInputOrder.setVolumeCondition(CtpConstants.THOST_FTDC_VC_CV);
                //触发条件:立即
                pInputOrder.setContingentCondition(CtpConstants.THOST_FTDC_CC_Immediately);
                break;
            default:
                break;
        }
        //报单requestID、报单引用orderRef 不能重复
        pInputOrder.setBrokerID(ctpBrokerID);
        pInputOrder.setUserID(ctpUserID);
        pInputOrder.setInvestorID(ctpUserID);

        CThostFtdcRspUserLoginField userLoginField = trade.getUserSession(ctpUserID);
        //考虑到ctp前置通过session、frontId、maxOrderRef防重，maxOrderRef每次请求+1
        int maxOrderRef = CtpUtil.getMaxOrderRef(userLoginField);
        pInputOrder.setRequestID(maxOrderRef);
        // 报单引用
        pInputOrder.setOrderRef(String.valueOf(maxOrderRef));
        //先保存报单信息
        ctpRspMsgSettleService.saveInputOrder(pInputOrder, userLoginField);
        trade.reqOrderInsert(pInputOrder, pInputOrder.getRequestID(), ctpUserID);
    }
}
