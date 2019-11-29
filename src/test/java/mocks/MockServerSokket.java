package mocks;

import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.Sokket;

import java.util.ArrayList;
import java.util.List;

public class MockServerSokket implements ServerSokket {

    private int port;
    private Sokket connectedSokket = null;
    private boolean closed = false;
    private List<Boolean> boundToAPort;

    public MockServerSokket(int port) {
        this.port = port;
    }

    private int callCountForAcceptConnectionAndReturnConnectedSokket = 0;

    public int getCallCountForAcceptConnectionAndReturnConnectedSokket() {
        return callCountForAcceptConnectionAndReturnConnectedSokket;
    }

    @Override
    public Sokket acceptConnectionAndReturnConnectedSokket() {
        callCountForAcceptConnectionAndReturnConnectedSokket += 1;
        return connectedSokket;
    }

    @Override
    public void close() {
        closed = true;
    }

    public boolean isClosed() {
        return closed;
    }

    public int getPort() {
        return port;
    }

    public void setMockSokketToReturnFollowingConnection(Sokket sokket) {
        connectedSokket = sokket;
    }

    public Sokket getConnectedSokket() {
        return connectedSokket;
    }

    @Override
    public boolean isBoundToAPort() {
        return boundToAPort.remove(0);
    }

    public void setIsBoudnToPort(ArrayList<Boolean> loopOccurences) {
        boundToAPort = loopOccurences;
    }
}

