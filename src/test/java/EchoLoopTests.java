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
        List messageFromClient = new ArrayList<String>();
        messageFromClient.add("Hello");
        sokket.setMockMessagesToReceiveFromClient(messageFromClient);

        assertTrue(sokket.getMessagesSentToClient().isEmpty());
        loop.run(sokket);

        assertEquals(messageFromClient, sokket.getMessagesSentToClient());
    }

     @Test public void testRunContinuesTheLoopUntilClientSendsExitMessage() throws IOException {
        MockSokket sokket = new MockSokket();
        List messagesFromClient = new ArrayList(Arrays.asList("Hello!", "How are you?", "exit!"));
        sokket.setMockMessagesToReceiveFromClient(messagesFromClient);
        List expectedMessagesSentToClient = new ArrayList(Arrays.asList("Hello!", "How are you?"));
        loop.run(sokket);

        assertEquals(expectedMessagesSentToClient, sokket.getMessagesSentToClient());
     }


}
