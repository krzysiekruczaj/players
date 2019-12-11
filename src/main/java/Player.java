public class Player {
    private int messageCounter = 0;

    public Message receiveMessage(String message) {
        ++messageCounter;
        return new Message(message + messageCounter, messageCounter);
    }

}
