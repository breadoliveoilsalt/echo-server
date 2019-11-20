import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class EchoServerTest {

    int samplePort = 8000;
    ServerSokket mockServerSokket;
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

    @Test public void testRunBindsTheServerSocketToAPort() throws IOException {
        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);

        assertThat((((MockServerSokket) mockServerSokket).methodLog()), hasItems("establishAndListenAtPort()"));
        assertEquals((((MockServerSokket) mockServerSokket).portAssigned()), samplePort);
    }

    @Test public void testRunTellsServerSocketToReturnAConnectedSocketUponConnection() throws IOException {
        EchoServer.run(samplePort, mockServerSokket, mockSendMessageProtocol);
        assertThat((((MockServerSokket) mockServerSokket).methodLog()), hasItems("acceptConnectionAndReturnConnectedSocket()"));
    }

}
