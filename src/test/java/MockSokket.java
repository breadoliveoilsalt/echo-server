public class MockSokket extends Sokket {

    private String messageSent;
    private boolean closed = false;

    @Override
    public void sendToOutputStream(String message) {
        messageSent = message;
    }

    @Override
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

