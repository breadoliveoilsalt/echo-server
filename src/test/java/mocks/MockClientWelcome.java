package mocks;

import echoServer.interfaces.ClientProtocol;

import java.io.IOException;

public class MockClientWelcome implements ClientProtocol {

    int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }

    @Override
    public void run() throws IOException {
        callCountForRun += 1;

    }
}
