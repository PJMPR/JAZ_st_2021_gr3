package com.pjwstk.sakila.websockets.contract;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class SakilaWebsocketConnectionProvider {

    private final ListenableFuture<StompSession> connection;

    public StompSession getConnection() throws ExecutionException, InterruptedException {
        return connection.get();
    }
}
