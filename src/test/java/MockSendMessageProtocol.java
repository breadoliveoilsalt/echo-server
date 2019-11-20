import java.io.IOException;

public class MockSendMessageProtocol extends ConnectionProtocol {

    Sokket sokket;

    @Override
    public void handleConnection(Sokket sokket) throws IOException {
        this.sokket = sokket;
    }

    public Sokket getSokket() {
       return this.sokket;
    }
}
