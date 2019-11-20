import java.io.IOException;
import java.util.ArrayList;

public class MockSokket extends Sokket {

    private ArrayList<String> methodLog;
    private String messageSent;

    MockSokket() {
        this.methodLog = new ArrayList<String>();
    }

    @Override
    String readInputStream() throws IOException {
        methodLog.add("readInputStream()");
        return "";
    }

    @Override
    void sendToOutputStream(String message) throws IOException {
        messageSent = message;
        boolean add = methodLog.add("sendToOutputStream()");
    }

    @Override
    void close() throws IOException {
        methodLog.add("close()");
    }

    public ArrayList<String> methodLog() {
        return methodLog;
    }

    public String messageSent() {
        return messageSent;
    }
}

