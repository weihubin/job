package com.finrun.trading.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.model.ctp.CThostFtdcInstrumentField;
import com.finrun.trading.common.model.ctp.CThostFtdcQryInstrumentField;
import com.finrun.trading.common.model.ctp.CtpConstants;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.model.CtpInstrumentInfo;
import com.finrun.trading.service.CtpQryInstrumentService;
import com.finrun.trading.service.QryInstrumentService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weihubin on 2018-05-14.
 */
@Service
public class QryInstrumentServiceImpl extends CtpTradeCtlAbstract implements QryInstrumentService, CtpQryInstrumentService {

    private  ConcurrentMap<String, CThostFtdcInstrumentField> instrumentMapAll = new ConcurrentHashMap<String, CThostFtdcInstrumentField>();

    /**
     * 根据合约id, 查询合约信息
     * @param msg
     * @return
     * @throws Exception
     */
    @Override
    public ResultDto qryInstrument(String msg) throws Exception {
        JSONObject jsonObject = JSON.parseObject(msg);
        String instrumentID = jsonObject.getString("instrumentID");
        if(instrumentMapAll.containsKey(instrumentID)){
            CThostFtdcInstrumentField instrumentField = instrumentMapAll.get(instrumentID);
            //PO映射
            return ResultUtil.success(CtpInstrumentInfo.transInstrumentInfo(instrumentField));
        }else {
            //查询数据库
            return ResultUtil.success(ctpRspMsgSettleService.qryInstrumentInfoById(instrumentID));
        }
    }

    @Override
    public ResultDto synInstruments() throws Exception {
        setCtpQryInstrumentService(this);
        //查询所有合约
        qryInstrumentCtl();

        ctpRspMsgSettleService.updateAllInstruments(instrumentMapAll);

        return ResultUtil.success();
    }


    @Override
    public void ctpQryInstruments() throws Exception{
        //根据交易所去查询合约信息
        Set<String> exchanges = CtpConstants.EXCHANGE_MICCODE_MAPPINGS.keySet();
        for (String exchange : exchanges) {
            qryInstrumentMap(exchange, instrumentMapAll);
        }
    }


    /**
     *  获取交易所对应的所有合约
     * @param exchangeID 交易所代码
     * @param instrumentMapAll
     * @throws Exception
     */
    private void qryInstrumentMap(String exchangeID, ConcurrentMap<String, CThostFtdcInstrumentField> instrumentMapAll) throws Exception {
        CThostFtdcQryInstrumentField pQryInstrument = new CThostFtdcQryInstrumentField();
        if (exchangeID != null) {
            pQryInstrument.setExchangeID(exchangeID);
        }
        trade.reqQryInstrument(pQryInstrument, new AtomicInteger().getAndIncrement(), ctpUserID);
        CountDownLatch latch = new CountDownLatch(1);
        trade.setLatch(latch);
        ConcurrentMap<String, CThostFtdcInstrumentField> instrumentMap = trade.getInstruments();
        if (instrumentMap != null) {
            instrumentMapAll.putAll(instrumentMap);
        }
        TimeUnit.SECONDS.sleep(5);
    }
}
