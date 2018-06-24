package com.finrun.trading.websocket.service.impl;

import com.finrun.trading.websocket.service.WebSocketSender;
import com.finrun.trading.websocket.service.WebSocketSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * WebSocket 管理类, 实现了发送接口和 Session管理接口
 *
 */
@Component
public class WebSocketManager implements WebSocketSender, WebSocketSessionManager {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ConcurrentHashMap<WebSocketSession,String> webSocketClients = new ConcurrentHashMap();

    public WebSocketManager() {
        //默认状态是隔50秒发送一次，应为一般timeout时间是60s
        websocketInit(50000);
    }

    public WebSocketManager(long pingPongInterval) {
        websocketInit(pingPongInterval);
    }

    private void websocketInit(long pingPongInterval){
        Timer timer = new Timer();
//        10秒后开始发送ping pong数据，保持WebSocket链接
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                logger.info("send Ping message to clients");
                for(WebSocketSession session : webSocketClients.keySet()){
                    try {
                        session.sendMessage(formatContent("heartbeat ping"));
                    } catch (IOException e) {
                        logger.info("发送Ping命令失败", e);
                    }
                }

            }
        },10000, pingPongInterval);
    }

    /**
     * 获取所有 websocketInit session, 直接发送
     * @param message
     */
    public void sendMsgToAllClient(String message){
        logger.info("Will send message to client , clients:" + webSocketClients.size() + ", content:" + message);
        for(WebSocketSession session : webSocketClients.keySet()){
            try {
                session.sendMessage(formatContent(message));
             } catch (Exception e) {
                logger.error("验证失败！", e);
            }
        }
    }

    private WebSocketMessage formatContent(String message){
        return new TextMessage(message);
    }

    /**
     * 断开连接将 session 从系统中清除
     * @param session
     */
    @Override
    public void removeSession(WebSocketSession session) {
        webSocketClients.remove(session);
    }
    /**
     * 新连接到达时, 添加 session
     * @param session
     */
    @Override
    public void addSession(WebSocketSession session) {
        webSocketClients.put(session,"");
    }

    @Override
    public int webSocketCount() {
        return webSocketClients.size();
    }
}
