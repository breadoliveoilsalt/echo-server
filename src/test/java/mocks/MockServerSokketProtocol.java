package mocks;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class MockServerSokketProtocol implements ServerSokketProtocol {

    private ServerSokket serverSokketArgument;
    private AppFactory factoryArgument;
    private int callCountForRun = 0;
    public int getCallCountForRun() {
        return callCountForRun;
    }


    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        this.serverSokketArgument = serverSokket;
        this.factoryArgument = factory;
        this.callCountForRun += 1;
    }

    public ServerSokket getServerSokketArgument() {
        return serverSokketArgument;
    }

    public AppFactory getFactoryArgument() {
        return factoryArgument;
    }

}
