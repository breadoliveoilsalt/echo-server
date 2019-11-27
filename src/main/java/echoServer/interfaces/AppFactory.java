package echoServer.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface AppFactory {

    public ServerSokket createServerSocketListeningAtPort(int port) throws IOException;

    public Reader createReader(InputStream inputStream);

    public Writer createWriter(OutputStream outputStream);

    public Runnable createEchoLoop(Sokket connectedSokket, AppFactory factory);

    public Thread createThreadFor(Runnable runnable);

}
