import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class EchoServerTest {

    @Test public void testRunBindsTheServerSocketToAPort() throws IOException {
        int samplePort = 8000;
        ServerSokket serverSocketSpy = new ServerSokketSpy();
        EchoServer.run(serverSocketSpy, ConnectionProtocolSpy);
        Sokket sokketSpy = new SokketSpy();
        ConnectionProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("sendToOutputStream()"));
    }
}
