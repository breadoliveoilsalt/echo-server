import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class EchoServerTest {

    private int samplePort = 8000;
    private MockServerSokket serverSokket;
    private MockConnectionProtocol connectionProtocol;

    @Before
    public void init() {
        serverSokket = new MockServerSokket();
        connectionProtocol = new MockConnectionProtocol();
    }

    @Test public void testRunBindsTheServerSokketToTheSamplePort() throws IOException {
        assertEquals(serverSokket.getPort(), 0);

        EchoServer.run(samplePort, serverSokket, connectionProtocol);

        assertEquals(serverSokket.getPort(), samplePort);
    }

    @Test public void testRunPassesAConnectedSokketToTheProtocolToHandleConnection() throws IOException {
        Sokket connectedSokket = new MockSokket();
        serverSokket.setMockSokketToReturnFollowingConnection(connectedSokket);

        EchoServer.run(samplePort, serverSokket, connectionProtocol);

        assertSame(connectedSokket, connectionProtocol.getConnectedSokket());
    }

    @Test public void testRunClosesTheSokketServer() throws IOException {
        assertFalse(serverSokket.isClosed());

        EchoServer.run(samplePort, serverSokket, connectionProtocol);

        assertTrue(serverSokket.isClosed());
    }

}
