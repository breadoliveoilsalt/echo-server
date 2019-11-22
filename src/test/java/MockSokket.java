public class MockSokket implements Sokket {

    private String messageSent;
    private boolean closed = false;

    public void sendToOutputStream(String message) {
        messageSent = message;
    }

    public void close() {
        closed = true;
    }

    public String getMessageSent() {
        return messageSent;
    }

    public boolean isClosed() {
        return closed;
    }

}

