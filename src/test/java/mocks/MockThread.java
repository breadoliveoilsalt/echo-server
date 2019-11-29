package mocks;

public class MockThread extends Thread {

    private boolean started = false;

    public boolean wasStarted() {
        return started;
    }

    public void start() {
        started = true;
    }



}
