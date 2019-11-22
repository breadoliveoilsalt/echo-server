import java.io.IOException;

public class EchoLoop {

    public void run(Sokket sokket) throws IOException {
        sokket.sendToOutputStream(sokket.readLine());
    }

}
