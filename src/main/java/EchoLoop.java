import java.io.IOException;

public class EchoLoop implements ConnectionProtocol {

    public void handleConnection(Sokket sokket) throws IOException {
        sokket.sendToOutputStream("Enter some text!");
        String clientMessage;
        while ((clientMessage = sokket.readLine()) != "exit!") {
            sokket.sendToOutputStream("** Back attcha: " + clientMessage + " **");
        }
        sokket.close();
    }

}
