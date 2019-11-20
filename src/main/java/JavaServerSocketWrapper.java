import java.io.IOException;
import java.net.ServerSocket;

public class JavaServerSocketWrapper extends ServerSokket {

    private ServerSocket serverSocket;

    public ServerSokket establishAndListenAtPort(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        return this;
    }

    public Sokket acceptConnectionAndReturnConnectedSocket() throws IOException {
        return new JavaSocketWrapper(serverSocket.accept());
    }

    public void close() throws IOException {
        serverSocket.close();
    }

}
