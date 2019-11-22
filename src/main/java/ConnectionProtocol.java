import java.io.IOException;

public interface ConnectionProtocol {

    void handleConnection(Sokket sokket) throws IOException;

}
