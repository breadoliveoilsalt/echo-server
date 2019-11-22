import java.io.IOException;

public abstract class ServerSokket {

    abstract void establishAndListenAtPort(int port) throws IOException;

    abstract Sokket acceptConnectionAndReturnConnectedSokket() throws IOException;

    abstract void close() throws IOException;

}
