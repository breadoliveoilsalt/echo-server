package echoServer.logic;

import echoServer.interfaces.ClientProtocol;
import echoServer.interfaces.Writer;

public class EchoLoopClientWelcome {

    Writer writer;

    public EchoLoopClientWelcome(Writer writer) implements ClientProtocol {
        this.writer = writer;
    };

    public void run() {
        writer.printLine(
            "\n *** Welcome to Echo Server! *** \n" +
            "\n *** Type away, hit return, and watch your wisdom come back at you! *** \n" +
            "\n *** Type 'exit!' and hit return to disconnect *** \n"
        );
    }

}
