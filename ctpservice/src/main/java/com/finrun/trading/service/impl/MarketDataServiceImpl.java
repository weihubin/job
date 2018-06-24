package com.finrun.trading.service.impl;


import com.finrun.trading.common.CONST;
import com.finrun.trading.common.ctp.CTPMarketDataAdaptor;
import com.finrun.trading.common.ctp.callback.CTPMarketDataCallback;
import com.finrun.trading.common.model.ctp.*;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.CtpRspMsgSettleService;
import com.finrun.trading.service.MarketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weihubin on 2018-03-28.
 */
@Service
public class MarketDataServiceImpl implements MarketDataService {

    private static Logger LOGGER = LoggerFactory.getLogger(MarketDataServiceImpl.class);

    @Value("${ctp.ctpMarketDataFrontAddress}")
    private String ctpMarketDataFrontAddress;
    @Value("${ctp.ctpBrokerID}")
    private String ctpBrokerID;
    @Value("${ctp.ctpUserID}")
    private String ctpUserID;
    @Value("${ctp.ctpPassword}")
    private String ctpPassword;

    @Autowired
    private CtpRspMsgSettleService ctpRspMsgSettleService;

    @Override
    public ResultDto subscribeMarketData(String[] insArr) throws Exception{

        CTPMarketDataAdaptor marketDataAdaptor = new CTPMarketDataAdaptor();

        subMarketData(marketDataAdaptor, new CTPMarketDataCallback() {
            @Override
            public void onFrontConnected() {
            }
            @Override
            public void onFrontDisconnected(int nReason) {
            }
            @Override
            public void onHeartBeatWarning(int nTimeLapse) {
            }
            @Override
            public void onRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
            }
            @Override
            public void onRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("pRspUserLogin={}", pRspUserLogin);
                if(pRspUserLogin == null || pRspInfo ==null){
                    return;
                }
                if(0 == pRspInfo.getErrorID()){//登录成功
                    //行情订阅
                    marketDataAdaptor.subscribeMarketData(insArr, insArr.length);
                }
            }
            @Override
            public void onRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
            }
            @Override
            public void onRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("onRspError={}", pRspInfo);
            }
            @Override
            public void onRspSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
                LOGGER.info("pRspInfo={}", pRspInfo);
                LOGGER.info("pSpecificInstrument={}", pSpecificInstrument);
            }
            @Override
            public void onRspUnSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
            }
            @Override
            public void onRspSubForQuoteRsp(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
            }
            @Override
            public void onRspUnSubForQuoteRsp(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
            }
            @Override
            public void onRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
                LOGGER.info("pDepthMarketData={}", pDepthMarketData);
                ctpRspMsgSettleService.rtnDepthMarketDataStl(pDepthMarketData);
            }
            @Override
            public void onRtnForQuoteRsp(CThostFtdcForQuoteRspField pForQuoteRsp) {
            }
        });
//        try {
//            new CountDownLatch(1).await(10, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            throw e;
//        }
        return ResultUtil.success();
    }


    /**
     * 订阅行情。
     * @param marketDataCallback
     * @throws Exception
     */
    private void subMarketData(CTPMarketDataAdaptor marketDataAdaptor, CTPMarketDataCallback marketDataCallback) throws Exception {
        marketDataAdaptor.registerMarketDataCallback(marketDataCallback);
        CountDownLatch latch = new CountDownLatch(1);
        marketDataAdaptor.createJVM(false, CONST.GLogLevel.INFO.getKey(), CONST.GLogLevel.ERROR.getKey());
        marketDataAdaptor.setLatch(latch);
        try {
            Executors.newSingleThreadExecutor().submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    marketDataAdaptor.ctpInit(ctpMarketDataFrontAddress);
                    return null;
                }
            });
        } catch (Exception e) {
            LOGGER.error("subMarketData ctpInit error:", e);
        }
        LOGGER.info("wait for connecting the mds front machine!");
        latch.await();
        LOGGER.info("Connect to CTP mds front machine!");
        LOGGER.info("before user login for mds");
        CThostFtdcReqUserLoginField pReqUserLoginField = new CThostFtdcReqUserLoginField();
        pReqUserLoginField.setBrokerID(ctpBrokerID);
        pReqUserLoginField.setUserID(ctpUserID);
        pReqUserLoginField.setPassword(ctpPassword);
        LOGGER.info("user logining for mds");
        marketDataAdaptor.reqUserLogin(pReqUserLoginField, new AtomicInteger(1).incrementAndGet());
        LOGGER.info("user logined for mds");
    }




}
