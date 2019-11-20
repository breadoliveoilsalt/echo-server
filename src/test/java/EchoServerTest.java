import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class EchoServerTest {

    int samplePort = 8000;
    ServerSokket serverSokketSpy;
    ConnectionProtocol sendMessageProtocolSpy;

    @Before
    public void init() {
        this.serverSokketSpy = new ServerSokketSpy();
        this.sendMessageProtocolSpy = new SendMessageProtocolSpy();
    }

    @After
    public void tearDown() {
        this.serverSokketSpy = null;
        this.sendMessageProtocolSpy = null;
    }

    @Test public void testRunBindsTheServerSocketToAPort() throws IOException {
        EchoServer.run(samplePort, serverSokketSpy, sendMessageProtocolSpy);

        assertThat((((ServerSokketSpy) serverSokketSpy).methodLog()), hasItems("establishAndListenAtPort()"));
        assertEquals((((ServerSokketSpy) serverSokketSpy).portAssigned()), samplePort);
    }

    @Test public void testRunTellsServerSocketToReturnAConnectedSocketUponConnection() throws IOException {
        EchoServer.run(samplePort, serverSokketSpy, sendMessageProtocolSpy);
        assertThat((((ServerSokketSpy) serverSokketSpy).methodLog()), hasItems("acceptConnectionAndReturnConnectedSocket()"));
    }


}
