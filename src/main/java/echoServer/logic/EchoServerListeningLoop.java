package echoServer.logic;

import echoServer.interfaces.*;

import java.io.IOException;

public class EchoServerListeningLoop implements ServerSokketProtocol {

    private Sokket connectedSokket;
    private Thread threadToRun;

    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        while (serverSokket.isBoundToAPort()) {
            getSokketConnectedToClient(serverSokket);
            initializeThreadedEchoLoop(factory);
            runThread();
        }
    }

    private void getSokketConnectedToClient(ServerSokket serverSokket) throws IOException {
        connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
    }

    private void initializeThreadedEchoLoop(AppFactory factory) {
        Runnable echoLoopInit = factory.createEchoLoopInit(connectedSokket, factory);
        threadToRun = factory.createThreadFor(echoLoopInit);
    }

    private void runThread() {
        threadToRun.start();
    }

}
