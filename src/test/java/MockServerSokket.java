public class MockServerSokket extends ServerSokket {

    private int port;
    private Sokket connectedSokket = null;
    private boolean closed = false;

    @Override
    public ServerSokket establishAndListenAtPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public Sokket acceptConnectionAndReturnConnectedSokket() {
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
}

