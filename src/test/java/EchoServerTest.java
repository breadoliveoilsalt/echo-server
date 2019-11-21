import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class EchoServerTest {

    int samplePort = 8000;
    MockServerSokket mockServerSokket;
    MockSendMessageProtocol mockSendMessageProtocol;

    @Before
    public void init() {
        this.mockServerSokket = new MockServerSokket();
        this.mockSendMessageProtocol = new MockSendMessageProtocol();
    }

    @After
    public void tearDown() {
        this.mockServerSokket = null;
        this.mockSendMessageProtocol = null;
    }

    @Test public void testRunBindsTheServerSokketToAPort() throws IOException {
        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);

        assertThat(mockServerSokket.methodLog(), hasItems("establishAndListenAtPort()"));
        assertEquals(mockServerSokket.portAssigned(), samplePort);
    }

    @Test public void testRunTellsServerSokketToReturnAConnectedSokketUponConnection() throws IOException {
        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);

        assertThat(mockServerSokket.methodLog(), hasItems("acceptConnectionAndReturnConnectedSokket()"));
    }

    @Test public void testRunPassesTheConnectedSokketToTheProtocolToHandleConnection() throws IOException {
        Sokket expectedMockSokketArgument = new MockSokket();
        mockServerSokket.setMockSokketToReturn(expectedMockSokketArgument);

        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);

        assertThat(mockSendMessageProtocol.methodLog(), hasItems("handleConnection()"));
        assertSame(expectedMockSokketArgument, mockSendMessageProtocol.getSokketArgument());
    }

}
