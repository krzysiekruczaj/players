package org.example;

public interface Client {
    String getClientId();
    void receiveMessage(String senderId, String message);
    void disconnect();
}
