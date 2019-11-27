import echoServer.interfaces.ConnectionProtocol;
import echoServer.interfaces.ServerSokket;
import echoServer.logic.EchoLoopProtocol;
import echoServer.logic.EchoServer;
import echoServer.wrappers.JavaServerSocketWrapper;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSokket serverSokket = new JavaServerSocketWrapper();
        ConnectionProtocol echoLoopProtocol = new EchoLoopProtocol();

        EchoServer.run(port, serverSokket, echoLoopProtocol);
    }

}