package mocks;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class MockServerSokketProtocol implements ServerSokketProtocol {
    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {

    }
}
