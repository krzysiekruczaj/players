package org.example;

public class LocalApplication {
    public static void main(String[] args) {
        Server server = new LocalServer();
        Player firstPlayer = new Player();
        Client firstClient = new LocalClient(server, firstPlayer);

        Player secondPlayer = new Player();
        Client secondClient = new LocalClient(server, secondPlayer);

        secondClient.receiveMessage(firstClient.getClientId(), "Hello");
    }
}
