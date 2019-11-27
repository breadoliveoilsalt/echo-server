package echoServer.logic;

import echoServer.interfaces.Sokket;

public class EchoLoopWelcome {

    public static void welcomeClient(Sokket sokket) {
        sokket.sendToOutputStream(
            "\n *** Welcome to Echo Server! *** \n" +
            "\n *** Type away, hit return, and watch your wisdom come back at you! *** \n" +
            "\n *** Type 'exit!' and hit return to disconnect *** \n");

    }
}
