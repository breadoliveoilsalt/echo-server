import java.io.BufferedReader;
import java.io.IOException;

public interface Sokket {

   void sendToOutputStream(String message) throws IOException;

   String readLine() throws IOException;

   void close() throws IOException;

}
