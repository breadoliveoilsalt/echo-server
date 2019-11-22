import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EchoLoopTests {

    private EchoLoop loop;

    @Before
    public void init() {
        loop = new EchoLoop();
    }

    @Test
    public void testRunBeginsALoopThatReadsLineFromClientAndSendsSameMessageBackToClient() throws IOException {
        MockSokket sokket = new MockSokket();
        String messageFromClient = "Hello!";
        sokket.setMockMessageToReceiveFromClient(messageFromClient);

        assertNull(sokket.getMessageSentToClient());
        loop.run(sokket);
        assertSame(sokket.getMessageSentToClient(), messageFromClient);
    }

    // @Test public void testRunContinuesTheLoopUntilClientSendsExitMessage() {
    // }


}
