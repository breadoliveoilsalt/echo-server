import java.util.ArrayList;
import java.util.List;

public class MockSokket implements Sokket {

    private List mockMessagesFromClient;
    private int currentMessagePointer = 0;
    private List messagesSentToClient = new ArrayList<String>();
    private boolean closed = false;

    public void sendToOutputStream(String message) {
        messagesSentToClient.add(message);
    }

    public String readLine() {
        String message = String.valueOf(mockMessagesFromClient.get(currentMessagePointer));
        currentMessagePointer += 1;
        return message;
    }

    public void setMockMessagesToReceiveFromClient(List mockMessagesToReceiveFromClient) {
        this.mockMessagesFromClient = mockMessagesToReceiveFromClient;
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
