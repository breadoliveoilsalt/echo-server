package mocks;

import echoServer.interfaces.Sokket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MockSokketOLD {

    private List<String> mockMessagesFromClient;
    private int currentMessagePointer = 0;
    private List<String> messagesSentToClient = new ArrayList<>();
    private boolean closed = false;

    public void sendToOutputStream(String message) {
        messagesSentToClient.add(message);
    }

    public String readLine() {
        String message = String.valueOf(mockMessagesFromClient.get(currentMessagePointer));
        currentMessagePointer += 1;
        return message;
    }

    public void setMockMessagesToReceiveFromClient(List<String> mockMessagesToReceiveFromClient) {
        this.mockMessagesFromClient = mockMessagesToReceiveFromClient;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return null;
    }

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
