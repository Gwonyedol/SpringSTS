package com.chat.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {

	
	//WebSocketSession은 spring에서 WebSocket connection이 맺어진 세션을 가리킨다. 
	//웹소켓 연결을 통해 메세지를 보내고 닫을 수 있습니다
	//편하게 고수준 socket이라고 생각하자. 
	//해당 session을 통해서 메시지를 보낼(sendMessage()) 수 있다.
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	//※클라이언트 연결 된 후
	//WebSocketSession을 매개 변수로 받고 클라이언트가 연결된 후 
	//해당 클라이언트의 정보를 가져와 연결확인 작업을한다.
	//클라이언트의 세션을 세션 저장 리스트에 add()로 추가 한다.
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
	}
	
	// 웹 소켓 서버로 데이터를 전송했을 경우
	//연결된 모든 클라이언트에게 메시지 전송 : 리스트
	//연결된 모든 사용자에게 보내야 하므로 for문으로 세션리스트에 있는 모든 세션들을 돌면서
	// sendMessage()를 이용해 데이터를 주고 받는다.
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	//연결되어있는 모든 클라이언트들에게 메세지를 전송함
		for(WebSocketSession sess: sessionList) {
			sess.sendMessage(new TextMessage(message.getPayload()));
		}
	}
	//※클라이언트와 연결이 끊어진 경우
	//add()와 반대로 remove()를 이용해서 세션리스트에서 제거한다.
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
	}
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception{
		System.out.println("오류가 났네용...");
	}
	
}
