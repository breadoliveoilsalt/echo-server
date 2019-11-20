import java.io.IOException;
import java.util.ArrayList;

public class MockServerSokket extends ServerSokket {

    private ArrayList<String> methodLog;
    private int portAssigned;
    private Sokket mockConnectedSokket = null;

    MockServerSokket() {
        this.methodLog = new ArrayList<String>();
    }

    public ServerSokket establishAndListenAtPort(int port) throws IOException {
        portAssigned = port;
        methodLog.add("establishAndListenAtPort()");
        return this;
    }

    public Sokket acceptConnectionAndReturnConnectedSokket() throws IOException {
        methodLog.add("acceptConnectionAndReturnConnectedSokket()");
        return mockConnectedSokket;
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

    public void setMockSokketToReturn(Sokket sokket) {
        mockConnectedSokket = sokket;
    }
}

