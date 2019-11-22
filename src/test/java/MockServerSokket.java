import java.util.ArrayList;
import java.util.List;

public class MockServerSokket extends ServerSokket {

    private List<String> methodLog = new ArrayList<>();
    private int port;
    private Sokket mockConnectedSokket = null;

    public boolean isClosed() {
        return closed;
    }

    private boolean closed = false;

    @Override
    public ServerSokket establishAndListenAtPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public Sokket acceptConnectionAndReturnConnectedSokket() {
        methodLog.add("acceptConnectionAndReturnConnectedSokket()");
        return mockConnectedSokket;
    }

    @Override
    public void close() {
        closed = true;
    }

    public List<String> methodLog() {
        return methodLog;
    }

    public int portAssigned() {
        return port;
    }

    public void setMockSokketToReturn(Sokket sokket) {
        mockConnectedSokket = sokket;
    }
}

