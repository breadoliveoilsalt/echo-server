package echoServer.logic;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class EchoServer {

    public static void start(int port, ServerSokketProtocol serverProtocol, AppFactory factory) throws IOException {
        ServerSokket serverSokket = null;
        
        try {
            serverSokket = factory.createServerSocketListeningAtPort(port);
            serverProtocol.run(serverSokket, factory);
        } finally {
            if (serverSokket != null) {
                serverSokket.close();
            }
        }
    }

}
