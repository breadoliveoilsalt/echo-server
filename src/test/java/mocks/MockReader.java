package mocks;

import echoServer.interfaces.Reader;

import java.io.IOException;
import java.util.List;

public class MockReader implements Reader {

    private List<String> mockMessagesFromClient;
    private boolean closed = false;

    @Override
    public String readLine() throws IOException {
        return mockMessagesFromClient.remove(0);
    }

    @Override
    public void close() throws IOException {
        closed = true;
    }

    public void setMockMessagesToReceiveFromClient(List<String> mockMessagesToReceiveFromClient) {
        this.mockMessagesFromClient = mockMessagesToReceiveFromClient;
    }

    public boolean isClosed() {
        return closed;
    }
}
