import java.io.IOException;

public abstract class ConnectionProtocol {

    public abstract void handleConnection(Sokket sokket) throws IOException;

}
