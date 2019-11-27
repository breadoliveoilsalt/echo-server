package echoServer.interfaces;

import java.io.IOException;

public interface Sokket {

   Object getInputStream(String message) throws IOException;

   Object getOutputStream() throws IOException;

   void close() throws IOException;

}
