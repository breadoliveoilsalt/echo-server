import java.io.IOException;

public class SendMessageProtocol implements ConnectionProtocol {

    public void handleConnection(Sokket sokket) throws IOException {
        sokket.sendToOutputStream("Hey there");
        sokket.close();
    }

}
