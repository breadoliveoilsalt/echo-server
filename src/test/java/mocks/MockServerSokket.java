package mocks;

import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.Sokket;

public class MockServerSokket implements ServerSokket {

    private int port;
    private Sokket connectedSokket = null;
    private boolean closed = false;

    public void establishAndListenAtPort(int port) {
        this.port = port;
    }

    public Sokket acceptConnectionAndReturnConnectedSokket() {
        return connectedSokket;
    }

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
}

