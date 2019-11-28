package mocks;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class MockServerSokketProtocol implements ServerSokketProtocol {

    private ServerSokket serverSokketArgument;
    private AppFactory factoryArgument;
    private boolean wasRun = false;

    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        this.serverSokketArgument = serverSokket;
        this.factoryArgument = factory;
        this.wasRun = true;
    }

    public boolean wasRun() {
        return wasRun;
    }

    public ServerSokket getServerSokketArgument() {
        return serverSokketArgument;
    }

    public AppFactory getFactoryArgument() {
        return factoryArgument;
    }

}
