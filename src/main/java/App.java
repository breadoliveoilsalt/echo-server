import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokketProtocol;
import echoServer.logic.EchoServer;
import echoServer.logic.EchoServerLoop;
import echoServer.wrappers.JavaWrapperAppFactory;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSokketProtocol echoServerProtocol = new EchoServerLoop();
        AppFactory factory = new JavaWrapperAppFactory();

        EchoServer.start(port, echoServerProtocol, factory);
    }

}