import java.io.IOException;

public class SendMessageProtocol extends ConnectionProtocol {

    @Override
    public void handleConnection(Sokket sokket) throws IOException {
        sokket.sendToOutputStream("Hey there");
        sokket.close();
    }

}
