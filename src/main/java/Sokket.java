import java.io.IOException;

public abstract class Sokket {

   abstract String readInputStream() throws IOException;

   abstract void sendToOutputStream(String message) throws IOException;

   abstract void close() throws IOException;

}
