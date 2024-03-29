package tests;

import echoServer.interfaces.ServerSokketProtocol;
import echoServer.interfaces.Sokket;
import echoServer.logic.EchoServerListeningLoop;
import mocks.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EchoServerListeningLoopTests {

    private MockServerSokket serverSokket;
    private MockAppFactory factory;
    private MockEchoLoopInit echoLoopInit;
    private MockThread thread;
    private ServerSokketProtocol echoServerListeningLoop;

    @Before
    public void testInit() {
        initServerSokket();
        initFactory();
        initEchoServerListeningLoop();
        setLoopToRunOnce();
    }

    private void initServerSokket() {
        int samplePort = 8000;
        Sokket sokket = new MockSokket(samplePort);
        serverSokket = new MockServerSokket();
        serverSokket.setMockSokketToReturnFollowingConnection(sokket);
    }

    private void initFactory() {
        echoLoopInit = new MockEchoLoopInit();
        thread = new MockThread(echoLoopInit);
        factory = new MockAppFactory()
            .setThreadToReturn(thread)
            .setEchoLoopInitToReturn(echoLoopInit);
    }

    private void initEchoServerListeningLoop() {
        echoServerListeningLoop = new EchoServerListeningLoop();
    }

    private void setLoopToRunOnce() {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList<>(Arrays.asList(true, false));
        serverSokket.setIsBoundToPort(loopConditionWhetherServerSokketIsBound);
    }

    @Test
    public void testRunLoopGetsASokketConnectedToClient() throws IOException {
        setLoopToRunOnce();

        echoServerListeningLoop.run(serverSokket, factory);

        assertEquals(1, serverSokket.getCallCountForAcceptConnectionAndReturnConnectedSokket());
    }

    @ Test
    public void testRunLoopInitializesAThreadedEchoLoop() throws IOException {
        setLoopToRunOnce();

        echoServerListeningLoop.run(serverSokket, factory);

        assertEquals(1, factory.getCallCountForCreateEchoLoopInit());
        assertEquals(1, factory.getCallCountForCreateThreadFor());
    }

    @Test
    public void testRunLoopStartsTheThread() throws IOException {
        setLoopToRunOnce();

        echoServerListeningLoop.run(serverSokket, factory);

        assertEquals(1, echoLoopInit.getRunCallCount());
        assertEquals(1, thread.getCallCountForStart());
    }

    @Test
    public void testRunLoopRepeatsSoLongAsServerSokketIsBound() throws IOException {
        setLoopToRunThreeTimes();

        echoServerListeningLoop.run(serverSokket, factory);

        assertEquals(3, serverSokket.getCallCountForAcceptConnectionAndReturnConnectedSokket());
        assertEquals(3, factory.getCallCountForCreateEchoLoopInit());
        assertEquals(3, factory.getCallCountForCreateThreadFor());
        assertEquals(3, echoLoopInit.getRunCallCount());
        assertEquals(3, thread.getCallCountForStart());

    }

    private void setLoopToRunThreeTimes() {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList<>(Arrays.asList(true, true, true, false));
        serverSokket.setIsBoundToPort(loopConditionWhetherServerSokketIsBound);
    }
}
