import java.io.IOException;

public interface ServerSokket {

    void establishAndListenAtPort(int port) throws IOException;

    Sokket acceptConnectionAndReturnConnectedSokket() throws IOException;

    void close() throws IOException;

}
