package echoServer.wrappers;

import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.Sokket;

import java.io.IOException;
import java.net.ServerSocket;

public class JavaServerSocketWrapper implements ServerSokket, AutoCloseable {

    private ServerSocket serverSocket;

    JavaServerSocketWrapper(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public Sokket acceptConnectionAndReturnConnectedSokket() throws IOException {
        return new JavaSocketWrapper(serverSocket.accept());
    }

    public void close() throws IOException {
        serverSocket.close();
    }

}
