import java.io.IOException;
import java.util.ArrayList;

public class MockSendMessageProtocol extends ConnectionProtocol {

    private ArrayList<String> methodLog = new ArrayList<String>();
    Sokket sokketArgument;

    @Override
    public void handleConnection(Sokket sokket) throws IOException {
        this.methodLog.add("handleConnection()");
        this.sokketArgument = sokket;
    }

    public Sokket getSokketArgument() {
       return this.sokketArgument;
    }

    public ArrayList<String> methodLog() {
        return this.methodLog;
    }
}
