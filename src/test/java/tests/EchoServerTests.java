package tests;

import echoServer.logic.EchoServer;
import mocks.MockAppFactory;
import mocks.MockServerSokket;
import mocks.MockServerSokketProtocol;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EchoServerTests {

    private int samplePort = 8000;
    private MockServerSokketProtocol protocol;
    private MockServerSokket serverSokket;
    private MockAppFactory factory;
    private EchoServer echoServer;

    @Before
    public void init() {
        protocol = new MockServerSokketProtocol();
        serverSokket = new MockServerSokket(samplePort);
        factory = new MockAppFactory();
        factory.setServerSokketToReturn(serverSokket);
        echoServer = new EchoServer(samplePort, protocol, factory);
    }

    @Test
    public void testStartInstantiatesAListeningServerSokket() throws IOException {
        assertFalse(factory.createdServerSokket());

        echoServer.start();

        assertTrue(factory.createdServerSokket());
        assertSame(serverSokket, echoServer.getServerSokket());
    }

    @Test
    public void testStartTellsTheProtocolToRunWithTheServerSokketAndTheFactory() throws IOException {
        assertFalse(protocol.wasRun());

        echoServer.start();

        assertTrue(protocol.wasRun());
        assertSame(serverSokket, protocol.getServerSokketArgument());
        assertSame(factory, protocol.getFactoryArgument());
    }

    @Test
    public void testStartClosesTheServerSokketAfterTheProtocolIsRun() throws IOException {
        echoServer.start();

        assertTrue(protocol.wasRun());
        assertTrue(serverSokket.isClosed());
    }

}
