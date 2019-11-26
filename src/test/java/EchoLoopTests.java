import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EchoLoopTests {

    private MockSokket sokket;
    private List<String> messagesFromClient;
    private List<String> expectedSentMessages;

    @Before
    public void init() {
        sokket = new MockSokket();
        messagesFromClient = new ArrayList<>();
        expectedSentMessages = new ArrayList<>();
    }

    @Test
    public void testRunBeginsALoopThatReadsLineFromClientAndSendsSameMessageBackToClient() throws IOException {
        messagesFromClient.addAll(Arrays.asList("Hello!", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messagesFromClient);
        expectedSentMessages.add("Hello!");

        assertTrue(sokket.getMessagesSentToClient().isEmpty());
        EchoLoop.run(sokket);

        assertEquals(expectedSentMessages, sokket.getMessagesSentToClient());
    }

     @Test public void testRunContinuesTheLoopUntilClientSendsExitMessage() throws IOException {
        messagesFromClient.addAll(Arrays.asList("Hello!", "How are you?", "Bye!", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messagesFromClient);
        expectedSentMessages.addAll(Arrays.asList("Hello!", "How are you?", "Bye!"));

        EchoLoop.run(sokket);

        assertEquals(expectedSentMessages, sokket.getMessagesSentToClient());
     }

     @Test public void testRunStopsAsSoonAsClientSendsExitMessage() throws IOException {
         messagesFromClient.addAll(Arrays.asList("exit!", "Hello!", "How are you?"));
         sokket.setMockMessagesToReceiveFromClient(messagesFromClient);

         EchoLoop.run(sokket);

         assertTrue((sokket.getMessagesSentToClient()).isEmpty());
     }

    @Test public void testRunClosesTheSokket() throws IOException {
        messagesFromClient.addAll(Arrays.asList("Hello!", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messagesFromClient);

        assertFalse(sokket.isClosed());
        EchoLoop.run(sokket);

        assertTrue(sokket.isClosed());
    }
}
