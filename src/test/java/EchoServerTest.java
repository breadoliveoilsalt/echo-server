import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class EchoServerTest {

    int samplePort = 8000;
    MockServerSokket mockServerSokket;
    ConnectionProtocol mockSendMessageProtocol;

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

    @Test public void testRunPassesTheConnectedSokketToTheProtocolToHandle() throws IOException {
        MockSokket expectedMockSokketArgument = new MockSokket();
        mockServerSokket.setMockSokketToReturn(expectedMockSokketArgument);

        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);
// running into problem with interface declaring a certain thing needs to be passed in...a certain type of thing...
        assertSame(expectedMockSokketArgument, mockSendMessageProtocol.getSokket());
    }

}
