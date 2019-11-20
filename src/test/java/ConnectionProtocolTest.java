import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

import java.io.IOException;

public class ConnectionProtocolTest {

    @Test public void testHandleConnectionSendsHeyThereToSocketOutputStream() throws IOException {
        Sokket sokketSpy = new SokketSpy();
        ConnectionProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("sendToOutputStream()"));
    }

    @Test public void testHandleConnectionClosesTheSocket() throws IOException {
        Sokket sokketSpy = new SokketSpy();
        ConnectionProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("close()"));
    }
}
