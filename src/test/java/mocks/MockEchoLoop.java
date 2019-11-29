package mocks;

import echoServer.interfaces.ClientProtocol;
import echoServer.interfaces.Reader;
import echoServer.interfaces.Writer;
import echoServer.logic.EchoLoop;

import java.io.IOException;

public class MockEchoLoop implements ClientProtocol {

    private boolean wasRun = false;
    public boolean wasRun() {
        return wasRun;
    }

    public MockEchoLoop(Reader reader, Writer writer) {
    }

    public void run() throws IOException {
        wasRun = true;
    }

}
