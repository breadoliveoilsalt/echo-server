import java.io.IOException;
import java.net.ServerSocket;

public class JavaServerSocketWrapper extends ServerSokket {

    private ServerSocket serverSocket;

    @Override
    public ServerSokket establishAndListenAtPort(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        return this;
    }

    @Override
    public Sokket acceptConnectionAndReturnConnectedSokket() throws IOException {
        return new JavaSocketWrapper(serverSocket.accept());
    }

    @Override
    public void close() throws IOException {
        serverSocket.close();
    }

}
