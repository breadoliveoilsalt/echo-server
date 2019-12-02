package mocks;

import echoServer.interfaces.ClientProtocol;
import echoServer.interfaces.Reader;
import echoServer.interfaces.Writer;

import java.io.IOException;

public class MockEchoLoop implements ClientProtocol {

    private int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }

    public MockEchoLoop(Reader reader, Writer writer) {
    }

    public void run() throws IOException {
       callCountForRun += 1;
    }

}
