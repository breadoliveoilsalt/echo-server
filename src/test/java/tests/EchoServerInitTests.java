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
        serverSokket = new MockServerSokket(samplePort);
        factory = new MockAppFactory();
        factory.setServerSokketToReturn(serverSokket);
        echoServer = new EchoServerInit(samplePort, protocol, factory);
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
