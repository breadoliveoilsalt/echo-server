import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSokket serverSokket = new JavaServerSocketWrapper();
        ConnectionProtocol sendMessageProtocol = new SendMessageProtocol();

        EchoServer.run(port, serverSokket, sendMessageProtocol);
    }

}