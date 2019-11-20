import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertSame;

import java.io.IOException;

public class SendMessageProtocolTest {

    @Test public void testHandleConnectionSendsHeyThereToSocketOutputStream() throws IOException {
        Sokket sokketSpy = new SokketSpy();
        ConnectionProtocol testedProtocol = new SendMessageProtocol();
        testedProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("sendToOutputStream()"));
        assertSame(((SokketSpy) sokketSpy).messageSent(), "Hey there");
    }

    @Test public void testHandleConnectionClosesTheSocket() throws IOException {
        Sokket sokketSpy = new SokketSpy();
        ConnectionProtocol testedProtocol = new SendMessageProtocol();
        testedProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("close()"));
    }
}
