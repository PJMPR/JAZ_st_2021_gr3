package com.pjwstk.sakila.websockets.contract;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Configuration
public class WebSocketConnectionConfiguration {



    @Bean
    public ListenableFuture<StompSession> getStompConnection(
            @Value("#{sakila.websocket.income.queue}") String queue,
            @Value("#{sakila.websocket.host}") String host
            ){
        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
       var sessionHandler = new ChatStompSesionHandler();
       sessionHandler.setIncomeQueueName(queue);
        var connection = stompClient.connect(host, sessionHandler);
        return connection;
    }
}
