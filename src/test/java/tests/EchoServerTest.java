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
    private EchoServer echoServer;
    private ServerSokketProtocol protocol;
    private MockAppFactory factory;

    @Before
    public void init() {
        protocol = new MockServerSokketProtocol();
        factory = new MockAppFactory();
        echoServer = new EchoServer(samplePort, protocol, factory);
    }

    @Test
    public void testStartInstantiatesAServerSokketThroughTheFactory() throws IOException {
        MockServerSokket mockServerSokket = new MockServerSokket(samplePort);
        factory.setServerSokket(mockServerSokket);

        assertFalse(factory.createdServerSokket());
        echoServer.start();

        assertTrue(factory.createdServerSokket());
        assertSame(mockServerSokket, echoServer.getServerSokket());
    }

//    @Test
//    public void testStartTellsTheProtocolToRunWithTheServerSokketAndTheFactory() {
//        factory.setServerSokket(new MockServerSokket());
//
//    }
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
