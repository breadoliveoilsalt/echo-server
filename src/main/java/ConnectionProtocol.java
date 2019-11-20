import java.io.IOException;

public interface ConnectionProtocol {

    public void handleConnection(Sokket socket) throws IOException;

}
