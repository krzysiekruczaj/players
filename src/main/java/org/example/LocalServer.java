package org.example;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LocalServer implements Server {
    private Map<String, Client> clientsById = new ConcurrentHashMap<>();

    @Override
    public void receiveMessage(String senderId, String receiverId, Message message) {
        if (shouldDisconnectSender(message)) {
            Client sender = clientsById.remove(senderId);
            if (sender != null) {
                sender.disconnect();
            }
        }
        sendMessage(senderId, receiverId, message.getMessage());
    }

    private void sendMessage(String senderId, String receiverId, String message) {
        Client client = clientsById.get(receiverId);
        if (client != null) {
            client.receiveMessage(senderId, message);
        }
    }

    private boolean shouldDisconnectSender(Message message) {
        return message.getMessageCounter() >= 10;
    }

    @Override
    public String registerClient(Client client) {
        String clientId = generateClientId();
        clientsById.put(clientId, client);
        return clientId;
    }

    private String generateClientId() {
        return UUID.randomUUID().toString();
    }
}
