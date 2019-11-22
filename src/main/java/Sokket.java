import java.io.IOException;

public interface Sokket {

   void sendToOutputStream(String message) throws IOException;

   void close() throws IOException;

}
