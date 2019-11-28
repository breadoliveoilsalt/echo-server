package mocks;

import echoServer.interfaces.Sokket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MockSokket implements Sokket {

    private boolean gotInputStream = false;
    private boolean gotOutputStream = false;
    private boolean closed = false;

    @Override
    public InputStream getInputStream() throws IOException {
        gotInputStream = true;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        gotInputStream = true;
    }

    @Override
    public void close() throws IOException {
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
