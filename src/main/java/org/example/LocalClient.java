package org.example;

public class LocalClient implements Client {
    private Server server;
    private Player player;
    private String clientId;

    public LocalClient(Server server, Player player) {
        this.server = server;
        this.player = player;
        this.clientId = this.server.registerClient(this);
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public void receiveMessage(String senderId, String message) {
        Message response = player.receiveMessage(message);
        System.out.printf("org.example.Client [%s] received [%d] message: [%s]\n", clientId, response.getMessageCounter(), message);
        sendResponse(senderId, response);
    }

    private void sendResponse(String senderId, Message response) {
        server.receiveMessage(clientId, senderId, response);
    }

    @Override
    public void disconnect() {
        System.out.printf("Shutting down client [%s]\n", clientId);
    }
}
