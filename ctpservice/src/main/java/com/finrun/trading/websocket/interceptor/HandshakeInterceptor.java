package com.finrun.trading.websocket.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;


/**
 * WebSocket拦截器
 */
@Component
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
                                   ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
		logger.info("建立握手前...");
		//可以移除代码, 配置websocket 已把 "*" 加入 origin
		String actOrigin = UriComponentsBuilder.fromHttpRequest(request).build().toString();
		request.getHeaders().setOrigin("*");
		return super.beforeHandshake(request, response, wsHandler, attributes);

	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
                               ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception ex) {
		logger.info("建立握手后...");
		super.afterHandshake(request, response, wsHandler, ex);
	}

}
