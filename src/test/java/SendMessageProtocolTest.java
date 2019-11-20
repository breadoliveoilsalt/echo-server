import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertSame;

import java.io.IOException;

public class SendMessageProtocolTest {

    Sokket mockSokket;
    ConnectionProtocol testedProtocol;

    @Before
    public void init() {
        this.mockSokket = new MockSokket();
        this.testedProtocol = new SendMessageProtocol();
    }

    @After
    public void tearDown() {
        this.mockSokket = null;
        this.testedProtocol = null;
    }

    @Test public void testHandleConnectionSendsHeyThereToSocketOutputStream() throws IOException {
        testedProtocol.handleConnection(mockSokket);
        assertThat(((MockSokket) mockSokket).methodLog(), hasItems("sendToOutputStream()"));
        assertSame(((MockSokket) mockSokket).messageSent(), "Hey there");
    }

    @Test public void testHandleConnectionClosesTheSocket() throws IOException {
        testedProtocol.handleConnection(mockSokket);
        assertThat(((MockSokket) mockSokket).methodLog(), hasItems("close()"));
    }

}
