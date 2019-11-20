import java.io.IOException;
import java.util.ArrayList;

public class SokketSpy extends Sokket {

    private ArrayList<String> methodLog;

    @Override
    String readInputStream() throws IOException {
        methodLog.add("readInputStream()");
        return "";
    }

    @Override
    void sendToOutputStream(String message) throws IOException {
        methodLog.add("sendToOutputStream()");
    }

    @Override
    void close() throws IOException {
        methodLog.add("sendToOutputStream()");
    }

    public ArrayList<String> methodLog() {
        return methodLog;
    }
}

