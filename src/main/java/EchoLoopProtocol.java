import java.io.IOException;

public class EchoLoopProtocol implements ConnectionProtocol {

    public void handleConnection(Sokket sokket) throws IOException {
        EchoLoopWelcome.welcomeClient(sokket);
        EchoLoop.run(sokket);
    }


}
