package echoServer.logic;

import echoServer.interfaces.Reader;
import echoServer.interfaces.Sokket;
import echoServer.interfaces.Writer;

import java.io.IOException;

public class EchoLoop implements Runnable {

    Reader reader;
    Writer writer;

    public EchoLoop(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void run() {
        try {
            String clientMessage = reader.readLine();
            while (!clientMessage.equals("exit!")) {
                writer.printLine(clientMessage);
                clientMessage = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
