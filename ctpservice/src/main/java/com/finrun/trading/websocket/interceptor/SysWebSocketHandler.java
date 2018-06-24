package com.finrun.trading.websocket.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.service.MarketDataService;
import com.finrun.trading.websocket.service.WebSocketSender;
import com.finrun.trading.websocket.service.WebSocketSessionManager;
import com.finrun.trading.websocket.service.impl.WebSocketManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;

/**
 * WebSocket 处理类
 */
@Component
public class SysWebSocketHandler implements WebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MarketDataService marketDataService;

    @Autowired
    private WebSocketSender webSocketSender;

    @Autowired
    private WebSocketManager manager;

    public WebSocketSessionManager setSystemWebSocketHandler(WebSocketManager wssManager) {
        this.manager = wssManager;
        return wssManager;
    }

    /**
     * 连接成功时候触发
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        try {
            manager.addSession(session);
        } catch (Exception e) {
            logger.error("无法添加WebSocketSession！", e);
        }
    }

    /**
     * js调用websocket.send时候，会调用该方法
     * @param wss
     * @param wsm
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession wss, WebSocketMessage<?> wsm) throws Exception {
        //TODO
        //触发行情订阅，根据订阅白名单中合约行情
        String payloadMsg = wsm.getPayload().toString();
        logger.info("handleMessage:" + payloadMsg);
        ResultDto resultDto;
        try {
            JSONObject jsonObject = JSON.parseObject(payloadMsg);
            JSONArray array = jsonObject.getJSONArray("instrumentIdList");
            //行情订阅
            resultDto = marketDataService.subscribeMarketData(array.toArray(new String[0]));
        } catch(Exception fe) {
            logger.info(payloadMsg, fe);
            resultDto =  ResultUtil.error(fe.getMessage(), ExceptionEnum.ERROR.getCode());
        }
        String rtnMsg= JSON.toJSONString(resultDto);
        wss.sendMessage(formatContent(rtnMsg));
        manager.addSession(wss);
    }



    private WebSocketMessage formatContent(String message){
        return new TextMessage(message);
    }




    @Override
    public void handleTransportError(WebSocketSession wss, Throwable thrwbl) throws Exception {
        if (wss.isOpen()) {
            try {
                wss.close();
            } catch (IOException e) {
                logger.error("关闭WebSocket失败！", e);
            }
        }
    }

    /**
     * 关闭连接时触发
     * @param wss
     * @param cs
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession wss, CloseStatus cs) throws Exception {
        logger.info(wss + "is closed , due to " + cs.getReason());
        try {
            wss.close(CloseStatus.NORMAL);
            manager.removeSession(wss);
        } catch (Exception e) {
            logger.error("关闭WebSocket失败！", e);
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return true;
    }

}
