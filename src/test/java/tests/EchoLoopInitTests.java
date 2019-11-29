package tests;

import echoServer.interfaces.*;
import echoServer.logic.EchoLoopInit;
import mocks.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EchoLoopInitTests {

    private int samplePort = 8000;
    private MockAppFactory factory;
    private MockReader reader;
    private MockWriter writer;
    private EchoLoopInit echoLoopInit;
    private MockClientWelcome welcomer;
    private MockEchoLoop echoLoop;

    @Before
    public void testInit() {
        initFactory();
        initEchoLoopInit();
    }

    private void initFactory() {
        factory = new MockAppFactory();
        reader = new MockReader();
        factory.setReaderToReturn(reader);
        writer = new MockWriter();
        factory.setWriterToReturn(writer);
        welcomer = new MockClientWelcome();
        factory.setWelcomerToReturn(welcomer);
        echoLoop = new MockEchoLoop(reader, writer);
        factory.setEchoLoopToReturn(echoLoop);
    }

    private void initEchoLoopInit() {
        Sokket sokket = new MockSokket(samplePort);
        echoLoopInit = new EchoLoopInit(sokket, factory);
    }

    @Test
    public void testRunInitializesAReaderAndWriter() {
        echoLoopInit.run();

        assertEquals(1, factory.getCallCountForCreateReader());
        assertEquals(1, factory.getCallCountForCreateWriter());
    }

    @Test
    public void testRunCreatesAnInstanceOfAClientWelcomeProtocol() {
        echoLoopInit.run();

        assertEquals(1, factory.getCallCountForCreateWelcome() );
    }

    @Test
    public void testRunWelcomesTheClientByRunningTheClientWelcomeProtocol() {
        echoLoopInit.run();

        assertEquals(1, welcomer.getCallCountForRun());
    }

    @Test
    public void testRunRunsTheEchoLoop() {
        echoLoopInit.run();

        assertTrue(echoLoop.wasRun());
    }

    @Test
    public void testRunClosesTheReaderAndWriter() {
        echoLoopInit.run();

        assertTrue(reader.isClosed());
        assertTrue(writer.isClosed());
    }
}
