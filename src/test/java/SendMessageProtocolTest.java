import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertSame;

import java.io.IOException;

public class SendMessageProtocolTest {

    MockSokket mockSokket;
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

    @Test public void testHandleConnectionSendsHeyThereToSokketOutputStream() throws IOException {
        testedProtocol.handleConnection(mockSokket);

        assertThat(mockSokket.methodLog(), hasItems("sendToOutputStream()"));
        assertSame(mockSokket.messageSent(), "Hey there");
    }

    @Test public void testHandleConnectionClosesTheSokket() throws IOException {
        testedProtocol.handleConnection(mockSokket);

        assertThat(mockSokket.methodLog(), hasItems("close()"));
    }

}
