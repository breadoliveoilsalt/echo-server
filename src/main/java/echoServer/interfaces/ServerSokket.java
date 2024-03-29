package echoServer.interfaces;

import java.io.IOException;

public interface ServerSokket {

    Sokket acceptConnectionAndReturnConnectedSokket() throws IOException;

    boolean isBoundToAPort();

    void close() throws IOException;

}
