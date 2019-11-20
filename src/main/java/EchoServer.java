import java.io.IOException;

public class EchoServer {

    public static void run(int port, ServerSokket serverSokket, ConnectionProtocol connectionProtocol) throws IOException {
        serverSokket.establishAndListenAtPort(port);
        Sokket connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
        connectionProtocol.handleConnection(connectedSokket);
    }

}
