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

public class EchoServerListentingLoopTests {

    private int samplePort = 8000;
    private MockServerSokket serverSokket;
    private MockAppFactory factory;
    private ServerSokketProtocol echoServerListeningLoop;
    private Runnable echoLoopInit;
    private MockThread thread;

    @Before
    public void testInit() {
        initServerSokket();
        initFactory();
        setLoopToRunOnce();
    }

    private void initServerSokket() {
        Sokket sokket = new MockSokket(samplePort);
        serverSokket = new MockServerSokket(samplePort);
        serverSokket.setMockSokketToReturnFollowingConnection(sokket);
    }

    private void initFactory() {
        factory = new MockAppFactory();
        echoServerListeningLoop = new EchoServerListeningLoop();
        thread = new MockThread();
//        note I don't seem to need this
//        and this will dictate what I need in the factory
//        factory.setEchoLoopInitToReturn(echoLoopInit);
        factory.setThreadToReturn(thread);
    }

    private void setLoopToRunOnce() {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList(Arrays.asList(true, false));
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

        assertEquals(1, thread.getCallCountForStart());
    }

    @Test
    public void testRunLoopRepeatsSoLongAsServerSokketIsBound() throws IOException {
        setLoopToRunThreeTimes();

        echoServerListeningLoop.run(serverSokket, factory);

        assertEquals(3, serverSokket.getCallCountForAcceptConnectionAndReturnConnectedSokket());
        assertEquals(3, factory.getCallCountForCreateEchoLoopInit());
        assertEquals(3, factory.getCallCountForCreateThreadFor());
        assertEquals(3, thread.getCallCountForStart());

    }

    private void setLoopToRunThreeTimes() {
        ArrayList<Boolean> loopConditionWhetherServerSokketIsBound = new ArrayList(Arrays.asList(true, true, true, false));
        serverSokket.setIsBoundToPort(loopConditionWhetherServerSokketIsBound);
    }
}