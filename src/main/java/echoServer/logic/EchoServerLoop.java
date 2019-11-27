package echoServer.logic;

import echoServer.interfaces.*;

import java.io.IOException;

public class EchoServerLoop implements ServerSokketProtocol {

    @Override
    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
        while (true) {
            Sokket connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
            Reader reader = factory.createReader(connectedSokket.getInputStream());
            Writer writer = factory.createWriter(connectedSokket.getOutputStream());
            Runnable echoLoop = factory.createEchoLoopRunnable(reader, writer);
            Thread newThread = factory.createThreadFor(echoLoop);
            newThread.start();
        }

    }

}
