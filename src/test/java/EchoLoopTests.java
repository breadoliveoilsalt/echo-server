import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EchoLoopTests {

    private EchoLoop loop;

    @Before
    public void init() {
        loop = new EchoLoop();
    }

    @Test
    public void testRunBeginsALoopThatReadsLineFromClientAndSendsSameMessageBackToClient() throws IOException {
        MockSokket sokket = new MockSokket();
        List messageFromClient = new ArrayList<String>(Arrays.asList("Hello!", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messageFromClient);
        List expectedMessageFromClient = new ArrayList(Arrays.asList("Hello!"));

        assertTrue(sokket.getMessagesSentToClient().isEmpty());
        loop.handleConnection(sokket);

        assertEquals(expectedMessageFromClient, sokket.getMessagesSentToClient());
    }

     @Test public void testRunContinuesTheLoopUntilClientSendsExitMessage() throws IOException {
        MockSokket sokket = new MockSokket();
        List messagesFromClient = new ArrayList(Arrays.asList("Hello!", "How are you?", "Bye!", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messagesFromClient);
        List expectedMessagesSentToClient = new ArrayList(Arrays.asList("Hello!", "How are you?", "Bye!"));
        loop.handleConnection(sokket);

        assertEquals(expectedMessagesSentToClient, sokket.getMessagesSentToClient());
     }


}
