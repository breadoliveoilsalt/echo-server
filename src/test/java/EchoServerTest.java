import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class EchoServerTest {

    private int samplePort = 8000;
    private MockServerSokket mockServerSokket;
    private MockSendMessageProtocol mockSendMessageProtocol;

    @Before
    public void init() {
        this.mockServerSokket = new MockServerSokket();
        this.mockSendMessageProtocol = new MockSendMessageProtocol();
    }

    @Test public void testRunBindsTheServerSokketToAPort() throws IOException {
        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);

        assertEquals(mockServerSokket.portAssigned(), samplePort);
    }

    @Test public void testRunPassesTheConnectedSokketToTheProtocolToHandleConnection() throws IOException {
        Sokket expectedMockSokketArgument = new MockSokket();
        mockServerSokket.setMockSokketToReturn(expectedMockSokketArgument);

        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);

        assertSame(expectedMockSokketArgument, mockSendMessageProtocol.getConnectedSokket());
    }

    @Test public void testRunClosesTheSokketServer() throws IOException {
        assertFalse(mockServerSokket.isClosed());

        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);

        assertTrue(mockServerSokket.isClosed());
    }

}
