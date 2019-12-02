package tests;

import echoServer.logic.EchoLoopInit;
import mocks.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EchoLoopInitTests {

    private MockAppFactory factory;
    private MockReader reader;
    private MockWriter writer;
    private MockSokket sokket;
    private EchoLoopInit echoLoopInit;
    private MockClientWelcome welcomer;
    private MockEchoLoop echoLoop;

    @Before
    public void testInit() {
        initFactory();
        initEchoLoopInit();
    }

    private void initFactory() {
        reader = new MockReader();
        writer = new MockWriter();
        welcomer = new MockClientWelcome();
        echoLoop = new MockEchoLoop(reader, writer);
        factory = new MockAppFactory()
            .setReaderToReturn(reader)
            .setWriterToReturn(writer)
            .setWelcomerToReturn(welcomer)
            .setEchoLoopToReturn(echoLoop);
    }

    private void initEchoLoopInit() {
        int samplePort = 8000;
        sokket = new MockSokket(samplePort);
        echoLoopInit = new EchoLoopInit(sokket, factory);
    }

    @Test
    public void testRunGetsInputStreamFromSokketAndInitializesAReader() {
        echoLoopInit.run();

        assertTrue(sokket.gotInputStream());
        assertEquals(1, factory.getCallCountForCreateReader());
    }

    @Test
    public void testRunGetsOutputStreamFromSokketAndInitializesAWriter() {
        echoLoopInit.run();

        assertTrue(sokket.gotOutputStream());
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
    public void testRunInstantiatesAndRunsTheEchoLoop() {
        echoLoopInit.run();

        assertEquals(1, factory.getCallCountForCreateEchoLoop());
        assertEquals(1, echoLoop.getCallCountForRun());
    }

    @Test
    public void testRunClosesTheReaderAndWriter() {
        echoLoopInit.run();

        assertTrue(reader.isClosed());
        assertTrue(writer.isClosed());
    }

    @Test
    public void testRunClosesTheSokket() {
        echoLoopInit.run();

        assertTrue(sokket.isClosed());
    }
}
