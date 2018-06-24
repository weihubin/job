package com.finrun.trading.websocket;

import com.finrun.trading.websocket.interceptor.HandshakeInterceptor;
import com.finrun.trading.websocket.interceptor.SysWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

/**
 * Created by weihubin on 2018-05-31.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements  WebSocketConfigurer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/websocket").setAllowedOrigins("*").addInterceptors(new HandshakeInterceptor());
        registry.addHandler(webSocketHandler(), "/sockjs/websocket").addInterceptors(new HandshakeInterceptor())
                .setAllowedOrigins("*")
                .withSockJS();
        logger.info("启动时 WebSocket 注册, 位置：/websocket 和/sockjs/websocket" );
    }

    @Bean
    public WebSocketHandler webSocketHandler(){
        return new SysWebSocketHandler();
    }


}
