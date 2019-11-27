package echoServer.interfaces;

import java.io.IOException;

public interface ServerSokket {

    Sokket acceptConnectionAndReturnConnectedSokket() throws IOException;

    void close() throws IOException;

}
