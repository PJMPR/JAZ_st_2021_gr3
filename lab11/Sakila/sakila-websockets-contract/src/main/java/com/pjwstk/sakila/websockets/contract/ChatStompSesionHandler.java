package com.pjwstk.sakila.websockets.contract;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;

@Slf4j
@Setter
public class ChatStompSesionHandler implements StompSessionHandler {

    private String incomeQueueName;

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe(incomeQueueName, this);
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        log.error(exception.getMessage(), exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        log.error(exception.getMessage(), exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return OutMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
            OutMessage msg = (OutMessage) payload;
            log.info("Received: {}, from {}, time: {}", msg.getMsg(), msg.getName(), msg.getTime());
    }
}
