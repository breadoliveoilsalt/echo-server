package echoServer.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface AppFactory {

    public ServerSokket createServerSokketListeningAtPort(int port) throws IOException;

    public Reader createReader(InputStream inputStream);

    public Writer createWriter(OutputStream outputStream);

    public Runnable createEchoLoopInit(Sokket connectedSokket, AppFactory factory);

    public ClientProtocol createWelcomer(Writer writer);

    public ClientProtocol createEchoLoopProtocol;

    public Thread createThreadFor(Runnable runnable);

}
