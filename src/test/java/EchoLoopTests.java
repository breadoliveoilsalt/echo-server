import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EchoLoopTests {

    private EchoLoop loop;
    private MockSokket sokket;
    private List messagesFromClient;
    private List expectedSentMessages;

    @Before
    public void init() {
        loop = new EchoLoop();
        sokket = new MockSokket();
        messagesFromClient = new ArrayList();
        expectedSentMessages = new ArrayList();
    }

    @Test
    public void testRunBeginsALoopThatReadsLineFromClientAndSendsSameMessageBackToClient() throws IOException {
        messagesFromClient.addAll(Arrays.asList("Hello!", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messagesFromClient);
        expectedSentMessages.add("Hello!");

        assertTrue(sokket.getMessagesSentToClient().isEmpty());
        loop.handleConnection(sokket);

        assertEquals(expectedSentMessages, sokket.getMessagesSentToClient());
    }

     @Test public void testRunContinuesTheLoopUntilClientSendsExitMessage() throws IOException {
        messagesFromClient.addAll(Arrays.asList("Hello!", "How are you?", "Bye!", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messagesFromClient);
        expectedSentMessages.addAll(Arrays.asList("Hello!", "How are you?", "Bye!"));

        loop.handleConnection(sokket);

        assertEquals(expectedSentMessages, sokket.getMessagesSentToClient());
     }


}
