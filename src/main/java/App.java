import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSokket serverSokket = new JavaServerSocketWrapper();
        ConnectionProtocol echoProtocol = new EchoLoop();

        EchoServer.run(port, serverSokket, echoProtocol);
    }

}