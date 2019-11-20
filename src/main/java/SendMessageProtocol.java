import java.io.IOException;

public class SendMessageProtocol extends ConnectionProtocol {

    public void handleConnection(Sokket sokket) throws IOException {
        sokket.sendToOutputStream("Hey there");
        sokket.close();
    }

}
