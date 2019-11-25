import java.io.IOException;

public class EchoLoop {

    public void run(Sokket sokket) throws IOException {
        String clientMessage;
        while ((clientMessage = sokket.readLine()) != "exit!") {
            sokket.sendToOutputStream(clientMessage);
        }
    }

}
