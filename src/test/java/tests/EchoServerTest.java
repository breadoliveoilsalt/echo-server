package tests;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokketProtocol;
import org.junit.Before;
import org.junit.Test;

public class EchoServerTest {

    private int samplePort = 8000;
    private ServerSokketProtocol protocol;
    private AppFactory factory;

    @Before
    public void init() {
        protocol = new MockServerSokketProtocol();
        factory = new AppFactory();
    }

    @Test
    public void testStartInstantiatesAServerSokketListeningAtTheSamplePort() {
        assertEquals(serverSokket.getPort(), 0);

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
