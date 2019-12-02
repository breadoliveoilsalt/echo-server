package echoServer.wrappers;

import echoServer.interfaces.Writer;

import java.io.OutputStream;
import java.io.PrintWriter;

public class JavaPrintWriterWrapper implements Writer {

    PrintWriter writer;

    JavaPrintWriterWrapper(OutputStream outputStream) {
        writer = new PrintWriter(outputStream, true);
    }

    @Override
    public void printLine(String message) {
        writer.println(message);
    }

    @Override
    public void close() {
        writer.close();
    }

}
