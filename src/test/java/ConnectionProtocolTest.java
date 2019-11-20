import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectionProtocolTest {

    @Test public void testConnectionProtocolHandleConnectionReadsLineFromSocketInputStream() {
        Sokket sokketSpy = new SokketSpy();
        ConnectionProtocol.handleConnection(sokketSpy);
        assertThat(((SokketSpy) sokketSpy).methodLog(), hasItems("readInputStream()"));
    }
}
