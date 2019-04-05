package com.peerconnect;

import static java.time.LocalDateTime.now;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


@Component
public class WebSocketEventListener {

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	private final Logger logger = Logger.getLogger(WebSocketEventListener.class.getName());

	@EventListener(SessionConnectEvent.class)
	public void handleWebsocketConnectListener(SessionConnectEvent event) {
		logger.info("Received a new web socket connection : " + now());
	}

	@EventListener(SessionDisconnectEvent.class)
	public void handleWebsocketDisconnectListener(SessionDisconnectEvent event) {

	}

}
