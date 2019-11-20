import java.io.IOException;

public class SendMessageProtocol implements ConnectionProtocol {

    public void handleConnection(Sokket socket) throws IOException {
        socket.sendToOutputStream("Hey there");
        socket.close();
    }

}
