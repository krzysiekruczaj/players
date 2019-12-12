package org.example;

public interface Server {
    void receiveMessage(String senderId, String receiverId, Message message);

    String registerClient(Client client);
}
