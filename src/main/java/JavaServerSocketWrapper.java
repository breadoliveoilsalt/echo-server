import java.io.IOException;
import java.net.ServerSocket;

public class JavaServerSocketWrapper implements ServerSokket {

    private ServerSocket serverSocket;

    public void establishAndListenAtPort(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public Sokket acceptConnectionAndReturnConnectedSokket() throws IOException {
        return new JavaSocketWrapper(serverSocket.accept());
    }

    public void close() throws IOException {
        serverSocket.close();
    }

}
