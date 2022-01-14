package com.pjwstk.sakila.websockets.contract;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

@Component
public class SakilaWebsocketClient {


    public void run(String... args) throws Exception {
        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        var connection = stompClient.connect("ws://localhost:8080/chat", new ChatStompSesionHandler());

        new Scanner(System.in).nextLine();

        connection.get().send("/websocket/chat", new MyMessage("nowy", "kolejny test"));
        new Scanner(System.in).nextLine();
    }

}
