package echoServer.wrappers;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.Sokket;
import echoServer.logic.EchoLoop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class JavaWrapperAppFactory implements AppFactory {

    public JavaServerSocketWrapper createServerSokketListeningAtPort(int port) throws IOException {
        return new JavaServerSocketWrapper(port);
    }

    public JavaBufferedReaderWrapper createReader(InputStream inputStream) {
        return new JavaBufferedReaderWrapper(inputStream);
    }

    public JavaPrintWriterWrapper createWriter(OutputStream outputStream) {
        return new JavaPrintWriterWrapper(outputStream);
    }

    public Runnable createEchoLoop(Sokket connectedSokket, AppFactory factory) {
        return new EchoLoop(connectedSokket, factory);
    }

    public Thread createThreadFor(Runnable runnable) {
        return new Thread(runnable);
    }
}
