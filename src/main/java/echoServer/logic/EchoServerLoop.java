package echoServer.logic;

import echoServer.interfaces.*;

import java.io.IOException;

public class EchoServerLoop implements ServerSokketProtocol {

    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        while (true) {
            Sokket connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
            Runnable echoLoop = factory.createEchoLoop(connectedSokket, factory);
            Thread newThread = factory.createThreadFor(echoLoop);
            newThread.start();
        }

    }

}
