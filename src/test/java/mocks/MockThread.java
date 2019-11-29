package mocks;

public class MockThread extends Thread {

    private int callCountForStart = 0;

    public int getCallCountForStart() {
        return callCountForStart;
    }

    public void start() {
        callCountForStart += 1;
    }

}
