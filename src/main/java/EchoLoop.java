import java.io.IOException;

public class EchoLoop implements ConnectionProtocol {

    private String clientMessage;

    public void handleConnection(Sokket sokket) throws IOException {
        clientMessage = sokket.readLine();
        while (!clientMessage.equals("exit!")) {
            sokket.sendToOutputStream(clientMessage);
            clientMessage = sokket.readLine();
        }
        sokket.close();
    }

}
