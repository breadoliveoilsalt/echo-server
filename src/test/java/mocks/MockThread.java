package mocks;

public class MockThread extends Thread {

    Runnable mockEchoInit;

    public MockThread(Runnable mockEchoInit) {
        this.mockEchoInit = mockEchoInit;
    }
    private int callCountForStart = 0;

    public int getCallCountForStart() {
        return callCountForStart;
    }

    public void start() {
        callCountForStart += 1;
        mockEchoInit.run();
    }

}
