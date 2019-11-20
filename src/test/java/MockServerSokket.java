import java.io.IOException;
import java.util.ArrayList;

public class MockServerSokket extends ServerSokket {

    private ArrayList<String> methodLog;
    private int portAssigned;

    MockServerSokket() {
        this.methodLog = new ArrayList<String>();
    }

    public ServerSokket establishAndListenAtPort(int port) throws IOException {
        portAssigned = port;
        methodLog.add("establishAndListenAtPort()");
        return this;
    }

    public Sokket acceptConnectionAndReturnConnectedSocket() throws IOException {
        methodLog.add("acceptConnectionAndReturnConnectedSocket()");
        return new MockSokket();
    }

    public void close() throws IOException {
        methodLog.add("close()");
    }

    public ArrayList<String> methodLog() {
        return methodLog;
    }

    public int portAssigned() {
        return portAssigned;
    }

}

