import java.io.IOException;

public abstract class ServerSokket {

    abstract ServerSokket establishAndListenAtPort(int port) throws IOException;

    abstract Sokket acceptConnectionAndReturnConnectedSocket() throws IOException;

    abstract void close() throws IOException;

}
