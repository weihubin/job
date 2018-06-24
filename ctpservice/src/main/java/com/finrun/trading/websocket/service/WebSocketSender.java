package com.finrun.trading.websocket.service;

/**
 * Created by weihubin on 2018-06-01.
 */
public interface WebSocketSender {

    /**
     * 发送消息到所有连接的客户端
     * @param message
     */
    void sendMsgToAllClient(String message);


    int webSocketCount();

}
