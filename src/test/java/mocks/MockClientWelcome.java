package mocks;

import echoServer.interfaces.ClientProtocol;

public class MockClientWelcome implements ClientProtocol {

    int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }

    @Override
    public void run() {
        callCountForRun += 1;

    }
}
