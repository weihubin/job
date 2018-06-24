package com.finrun.trading.websocket.service;

import org.springframework.web.socket.WebSocketSession;


/**
 * WebSocketSession 管理接口
 */
public interface WebSocketSessionManager {

    void removeSession(WebSocketSession session);

    void addSession(WebSocketSession session);
}
