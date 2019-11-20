import java.io.IOException;

public class EchoServer {

    public static void run(int port, ServerSokket serverSocket, ConnectionProtocol connectionProtocol) throws IOException {
        serverSocket.establishAndListenAtPort(port);
        Sokket connectedSocket = serverSocket.acceptConnectionAndReturnConnectedSocket();
        connectionProtocol.handleConnection(connectedSocket);
    }

}
