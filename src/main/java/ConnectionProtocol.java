import java.io.IOException;

public class ConnectionProtocol {

    public static void handleConnection(Sokket socket) throws IOException {
       socket.sendToOutputStream("Hey there");
       socket.close();
    }
}
