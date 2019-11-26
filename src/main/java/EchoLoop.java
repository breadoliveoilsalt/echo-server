import java.io.IOException;

public class EchoLoop implements ConnectionProtocol {

    public void handleConnection(Sokket sokket) throws IOException {
        String clientMessage;
        while ((clientMessage = sokket.readLine()) != "exit!") {
            sokket.sendToOutputStream(clientMessage);
        }
        sokket.close();
    }

}
