import java.io.IOException;

public class EchoLoop {

    public static void run(Sokket sokket) throws IOException {
        String clientMessage = sokket.readLine();
        while (!clientMessage.equals("exit!")) {
            sokket.sendToOutputStream(clientMessage);
            clientMessage = sokket.readLine();
        }
        sokket.close();
    }

}
