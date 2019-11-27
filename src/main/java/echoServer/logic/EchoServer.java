package echoServer.logic;

import echoServer.interfaces.ConnectionProtocol;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.Sokket;

import java.io.IOException;

public class EchoServer {

    public static void run(int port, ServerSokket serverSokket, ConnectionProtocol connectionProtocol) throws IOException {
        serverSokket.establishAndListenAtPort(port);
        Sokket connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
        connectionProtocol.handleConnection(connectedSokket);
        serverSokket.close();
    }

}
