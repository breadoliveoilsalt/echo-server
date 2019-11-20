import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertSame;

public class EchoServerTest {

    @Test public void testRunBindsTheServerSocketToAPort() throws IOException {
        int samplePort = 8000;
        ServerSokket serverSokketSpy = new ServerSokketSpy();
        ConnectionProtocol sendMessageProtocolSpy = new SendMessageProtocolSpy();

        EchoServer.run(samplePort, serverSokketSpy, sendMessageProtocolSpy);

        assertThat((((ServerSokketSpy) serverSokketSpy).methodLog()), hasItems("establishAndListenAtPort()"));
        assertEquals((((ServerSokketSpy) serverSokketSpy).portAssigned()), samplePort);
    }

    @Test public void testRunTellsServerSocketToReturnAConnectedSocketUponConnection() throws IOException {
        int samplePort = 8000;
        ServerSokket serverSokketSpy = new ServerSokketSpy();
        ConnectionProtocol sendMessageProtocolSpy = new SendMessageProtocolSpy();

        EchoServer.run(samplePort, serverSokketSpy, sendMessageProtocolSpy);
        assertThat((((ServerSokketSpy) serverSokketSpy).methodLog()), hasItems("acceptConnectionAndReturnConnectedSocket()"));
    }
}
