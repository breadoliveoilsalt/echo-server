public class MockSokket implements Sokket {

    private String mockMessageToReceiveFromClient;
    private String messageSentToClient;
    private boolean closed = false;

    public void sendToOutputStream(String message) {
        messageSentToClient = message;
    }

    public String readLine() {
        return mockMessageToReceiveFromClient;
    }

    public void setMockMessageToReceiveFromClient(String mockMessageToReceiveFromClient) {
        this.mockMessageToReceiveFromClient = mockMessageToReceiveFromClient;
    }

    public void close() {
        closed = true;
    }

    public String getMessageSentToClient() {
        return messageSentToClient;
    }

    public boolean isClosed() {
        return closed;
    }

}

