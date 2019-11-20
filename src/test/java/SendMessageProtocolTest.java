import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertSame;

import java.io.IOException;

public class SendMessageProtocolTest {

    Sokket sokketSpy;
    ConnectionProtocol testedProtocol;

    @Before
    public void init() {
        this.sokketSpy = new SokketSpy();
        this.testedProtocol = new SendMessageProtocol();
    }

    @After
    public void tearDown() {
        this.sokketSpy = null;
        this.testedProtocol = null;
    }

    @Test public void testHandleConnectionSendsHeyThereToSocketOutputStream() throws IOException {
        testedProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("sendToOutputStream()"));
        assertSame(((SokketSpy) sokketSpy).messageSent(), "Hey there");
    }

    @Test public void testHandleConnectionClosesTheSocket() throws IOException {
        testedProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("close()"));
    }
}
