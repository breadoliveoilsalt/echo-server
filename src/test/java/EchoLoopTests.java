import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EchoLoopTests {

    private EchoLoop loop;

    @Before
    void init() {
        EchoLoop loop = new EchoLoop();
    }

    @Test
    public void testRunBeginsALoopThatReadsLineFromClientAndSendsSameMessageBackToClient() {
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
