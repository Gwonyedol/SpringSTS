package com.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
	@Autowired
	private EchoHandler echoHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoHandler, "/echo").setAllowedOrigins("*").withSockJS()
		.setInterceptors(new HttpSessionHandshakeInterceptor())
		.setClientLibraryUrl("http://192.168.1.36:8080/resources/sockjs.min.js");
		
		//웹소켓을 활성화하기 위해서 웹소켓핸들러레지스트리에 에드해여 메세지 핸들러를 매핑한다
		//setAllowedOrigins("*") wss통신을 가능하게 해줍니다
		//echo로 echoHandler를 매핑
		//withSockJS() : 서버쪽에서 SockJS 통신을 하기 위해서 통신요청.
		//@EnableWebSocketMessageBroker는 웹 소켓을 통해 STOMP를 사용한다
	}
	
	
}
