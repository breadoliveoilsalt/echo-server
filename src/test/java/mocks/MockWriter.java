package mocks;

import echoServer.interfaces.Writer;

import java.util.ArrayList;
import java.util.List;

public class MockWriter implements Writer {

    private List<String> messagesSentToClient = new ArrayList<>();

    private boolean closed = false;

    public void printLine(String message) {
        messagesSentToClient.add(message);
    }

    @Override
    public void close() {
        closed = true;
    }

    public List getMessagesSentToClient() {
        return messagesSentToClient;
    }

    public boolean isClosed() {
        return closed;
    }

}
