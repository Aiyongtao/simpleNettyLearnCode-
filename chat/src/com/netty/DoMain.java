package com.netty;

public class DoMain {
    public static void main(String[] args) {
        WebSocketServerImpl socketServer = new WebSocketServerImpl("localhost", 9999);
        socketServer.start();
    }

}
