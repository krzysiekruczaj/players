package org.example;

public class Message {
    private String message;
    private int messageCounter;

    public Message(String message, int messageCounter) {
        this.message = message;
        this.messageCounter = messageCounter;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageCounter() {
        return messageCounter;
    }
}
