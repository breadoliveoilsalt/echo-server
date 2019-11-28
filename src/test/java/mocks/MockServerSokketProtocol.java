package mocks;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class MockServerSokketProtocol implements ServerSokketProtocol {

    private ServerSokket serverSokket;
    private AppFactory factory;
    private boolean wasRun = false;

    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        this.serverSokket = serverSokket;
        this.factory = factory;
        this.wasRun = true;
    }

    public boolean wasRun() {
        return wasRun;
    }

}
