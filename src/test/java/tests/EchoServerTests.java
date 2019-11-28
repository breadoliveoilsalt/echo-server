package tests;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokketProtocol;
import echoServer.logic.EchoServer;
import mocks.MockAppFactory;
import mocks.MockServerSokket;
import mocks.MockServerSokketProtocol;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EchoServerTest {

    private int samplePort = 8000;
    private MockServerSokketProtocol protocol;
    private MockServerSokket mockServerSokket;
    private MockAppFactory factory;
    private EchoServer echoServer;

    @Before
    public void init() {
        protocol = new MockServerSokketProtocol();
        mockServerSokket = new MockServerSokket(samplePort);
        factory = new MockAppFactory();
        factory.setServerSokket(mockServerSokket);
        echoServer = new EchoServer(samplePort, protocol, factory);
    }

    @Test
    public void testStartInstantiatesAServerSokketThroughTheFactory() throws IOException {
        assertFalse(factory.createdServerSokket());

        echoServer.start();

        assertTrue(factory.createdServerSokket());
        assertSame(mockServerSokket, echoServer.getServerSokket());
    }

    @Test
    public void testStartTellsTheProtocolToRunWithTheServerSokketAndTheFactory() throws IOException {
        assertFalse(protocol.wasRun());

        echoServer.start();

        assertTrue(protocol.wasRun());
        assertSame(mockServerSokket, protocol.getServerSokketArgument());
        assertSame(factory, protocol.getFactoryArgument());
    }
}
//        EchoServer.run(samplePort, serverSokket, connectionProtocol);
//
//        assertEquals(serverSokket.getPort(), samplePort);
//    }}

//    private int samplePort = 8000;
//    private MockServerSokket serverSokket;
//    private MockConnectionProtocol connectionProtocol;
//
//    @Before
//    public void init() {
//        serverSokket = new MockServerSokket();
//        connectionProtocol = new MockConnectionProtocol();
//    }
//
//    @Test public void testRunBindsTheServerSokketToTheSamplePort() throws IOException {
//        assertEquals(serverSokket.getPort(), 0);
//
//        EchoServer.run(samplePort, serverSokket, connectionProtocol);
//
//        assertEquals(serverSokket.getPort(), samplePort);
//    }
//
//    @Test public void testRunPassesAConnectedSokketToTheProtocolToHandleConnection() throws IOException {
//        Sokket connectedSokket = new MockSokket();
//        serverSokket.setMockSokketToReturnFollowingConnection(connectedSokket);
//
//        EchoServer.run(samplePort, serverSokket, connectionProtocol);
//
//        assertSame(connectedSokket, connectionProtocol.getConnectedSokket());
//    }
//
//    @Test public void testRunClosesTheSokketServer() throws IOException {
//        assertFalse(serverSokket.isClosed());
//
//        EchoServer.run(samplePort, serverSokket, connectionProtocol);
//
//        assertTrue(serverSokket.isClosed());
//    }
//
//}
