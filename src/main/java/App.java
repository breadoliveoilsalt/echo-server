import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSokket serverSokket = new JavaServerSocketWrapper();
        ConnectionProtocol echoLoopProtocol = new EchoLoopProtocol();

        EchoServer.run(port, serverSokket, echoLoopProtocol);
    }

}