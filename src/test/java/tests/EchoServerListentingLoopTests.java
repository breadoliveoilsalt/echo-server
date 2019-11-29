package tests;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;
import echoServer.interfaces.Sokket;
import echoServer.logic.EchoLoopInit;
import echoServer.logic.EchoServerListeningLoop;
import mocks.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EchoServerListentingLoopTests {

    private int samplePort = 8000;
    MockServerSokket serverSokket;
    MockAppFactory factory;
    ServerSokketProtocol echoServerListeningLoop;
    Runnable echoLoopInit;
    Thread thread;

    @Before
    public void testInit() {
        Sokket sokket = new MockSokket(samplePort);
        serverSokket = new MockServerSokket(samplePort);
        serverSokket.setMockSokketToReturnFollowingConnection(sokket);
        factory = new MockAppFactory();
        echoServerListeningLoop = new EchoServerListeningLoop();
        thread = new MockThread();
        factory.setEchoLoopInitToReturn(echoLoopInit);
        factory.setThreadToReturn(thread);
    }

    @Test
    public void testRunLoopGetsASokketConnectedToClient() throws IOException {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList(Arrays.asList(true, false));
        serverSokket.setIsBoudnToPort(loopConditionWhetherServerSokketIsBound);

        echoServerListeningLoop.run(serverSokket, factory);

        assertEquals(1, serverSokket.getCallCountForAcceptConnectionAndReturnConnectedSokket());
    }

    @ Test
    public void testRunLoopInitializesAThreadedEchoLoop() throws IOException {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList(Arrays.asList(true, false));
        serverSokket.setIsBoudnToPort(loopConditionWhetherServerSokketIsBound);

        echoServerListeningLoop.run(serverSokket, factory);

        assertEquals(1, factory.getCallCountForCreateEchoLoopInit());
        assertEquals(1, factory.getCallCountForCreateThreadFor());
    }

    @Test
    public void testRunStartsTheThread() {

    }

}
//    @Override
//    public void run(ServerSokket serverSokket, AppFactory factory) throws IOException {
//        while (serverSokket.isBoundToAPort()) {
//            getSokketConnectedToClient(serverSokket);
//            initializeThreadedEchoLoop(factory);
//            runThread();
//        }
//    }
//
//    private void getSokketConnectedToClient(ServerSokket serverSokket) throws IOException {
//        connectedSokket = serverSokket.acceptConnectionAndReturnConnectedSokket();
//    }
//
//    private void initializeThreadedEchoLoop(AppFactory factory) {
//        Runnable echoLoopInit = factory.createEchoLoopInit(connectedSokket, factory);
//        threadToRun = factory.createThreadFor(echoLoopInit);
//    }
//
//    private void runThread() {
//        threadToRun.start();
//}
