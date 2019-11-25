import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class SendMessageProtocolTest {

    private MockSokket sokket;
    private ConnectionProtocol testedProtocol;

    @Before
    public void init() {
        sokket = new MockSokket();
        testedProtocol = new SendMessageProtocol();
    }

    @Test public void testHandleConnectionSendsHeyThereToSokketOutputStream() throws IOException {
        assertSame(sokket.getMessagesSentToClient(), null);

        testedProtocol.handleConnection(sokket);

        assertSame(sokket.getMessagesSentToClient(), "Hey there");
    }

    @Test public void testHandleConnectionClosesTheSokket() throws IOException {
        assertFalse(sokket.isClosed());

        testedProtocol.handleConnection(sokket);

        assertTrue(sokket.isClosed());
    }

}
