package mocks;

import echoServer.interfaces.Reader;
import echoServer.interfaces.Writer;
import echoServer.logic.EchoLoop;

import java.io.IOException;

public class MockEchoLoop extends EchoLoop {

    private Reader reader;
    private Writer writer;

    public MockEchoLoop(Reader reader, Writer writer) {
        super(reader, writer);
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
//        String clientMessage = reader.readLine();
//        while (!clientMessage.equals("exit!")) {
//            writer.printLine(clientMessage);
//            clientMessage = reader.readLine();
//        }
    }
}
