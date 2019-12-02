package tests;

import echoServer.logic.EchoServerInit;
import mocks.MockAppFactory;
import mocks.MockServerSokket;
import mocks.MockServerSokketProtocol;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class EchoServerInitTests {

    private int samplePort = 8000;
    private MockServerSokketProtocol protocol;
    private MockServerSokket serverSokket;
    private MockAppFactory factory;
    private EchoServerInit echoServer;

    @Before
    public void testInit() {
        protocol = new MockServerSokketProtocol();
        serverSokket = new MockServerSokket();
        factory = new MockAppFactory();
        factory.setServerSokketToReturn(serverSokket);
        echoServer = new EchoServerInit(samplePort, protocol, factory);
    }

    @Test
    public void testStartInstantiatesAListeningServerSokket() throws IOException {
        assertEquals(0, factory.getCallCountForCreateServerSokket());

        echoServer.start();

        assertEquals(1, factory.getCallCountForCreateServerSokket());
    }

    @Test
    public void testStartTellsTheProtocolToRunWithTheServerSokketAndTheFactory() throws IOException {
        assertEquals(0, protocol.getCallCountForRun());

        echoServer.start();

        assertEquals(1, protocol.getCallCountForRun());
        assertSame(serverSokket, protocol.getServerSokketArgument());
        assertSame(factory, protocol.getFactoryArgument());
    }

    @Test
    public void testStartClosesTheServerSokketAfterTheProtocolIsRun() throws IOException {
        echoServer.start();

        assertEquals(1, protocol.getCallCountForRun());
        assertTrue(serverSokket.isClosed());
    }

}
