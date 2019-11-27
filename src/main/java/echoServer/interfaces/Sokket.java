package echoServer.interfaces;

import java.io.IOException;

public interface Sokket {

   void sendToOutputStream(String message);

   String readLine() throws IOException;

   void close() throws IOException;

}
