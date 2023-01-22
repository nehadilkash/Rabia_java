package assignment;

public class Main {
    public static void main(String[] args) {

        PingPong ping = new PingPong("Ping");
        PingPong pong = new PingPong("Pong");

        Thread pingThread = new Thread(ping);
        Thread pongThread = new Thread(pong);

        pingThread.start();
        pongThread.start();

    }
}
