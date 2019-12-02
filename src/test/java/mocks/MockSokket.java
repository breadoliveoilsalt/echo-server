package mocks;

import echoServer.interfaces.Sokket;

import java.io.InputStream;
import java.io.OutputStream;

public class MockSokket implements Sokket {

    private int connectedPort;
    private boolean gotInputStream = false;
    private boolean gotOutputStream = false;
    private boolean closed = false;

    public MockSokket(int port) {
        connectedPort = port;
    }

    @Override
    public InputStream getInputStream() {
        gotInputStream = true;
        return new MockInputStream();
    }

    @Override
    public OutputStream getOutputStream() {
        gotOutputStream = true;
        return new MockOutputStream();
    }

    @Override
    public void close() {
        closed = true;
    }

    public boolean isClosed() {
        return closed;
    }

    public boolean gotInputStream() {
        return gotInputStream;
    }

    public boolean gotOutputStream() {
        return gotOutputStream;
    }

}
