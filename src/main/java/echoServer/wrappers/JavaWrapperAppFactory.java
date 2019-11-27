package echoServer.wrappers;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.Reader;
import echoServer.interfaces.Writer;
import echoServer.logic.EchoLoop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class JavaWrapperAppFactory implements AppFactory {

    public JavaServerSocketWrapper createServerSocketListeningAtPort(int port) throws IOException {
        return new JavaServerSocketWrapper(port);
    }

    public JavaBufferedReaderWrapper createReader(InputStream inputStream) {
        return new JavaBufferedReaderWrapper(inputStream);
    }

    public JavaPrintWriterWrapper createWriter(OutputStream outputStream) {
        return new JavaPrintWriterWrapper(outputStream);
    }

    public Runnable createEchoLoopRunnable(Reader reader, Writer writer) {
        return new EchoLoop(reader, writer);
    }

    public Thread createThreadFor(Runnable runnable) {
        return new Thread(runnable);
    }
}
