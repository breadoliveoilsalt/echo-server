package echoServer.logic;

import echoServer.interfaces.*;

import java.io.IOException;

public class EchoServerLoop implements ServerSokketProtocol {

    private Sokket connectedSokket;
    private Thread threadToRun;

    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        while (true) {
            getSokketConnectedToClient(serverSokket);
            initializeThreadedEchoLoop(factory);
            runThread();
        }
    }

    private void getSokketConnectedToClient(ServerSokket serverSokket) throws IOException {
        connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
    }

    private void initializeThreadedEchoLoop(AppFactory factory) {
        Runnable echoLoop = factory.createEchoLoop(connectedSokket, factory);
        threadToRun = factory.createThreadFor(echoLoop);
    }

    private void runThread() {
        threadToRun.start();
    }

}
