package echoServer.logic;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.Reader;
import echoServer.interfaces.Sokket;
import echoServer.interfaces.Writer;

import java.io.IOException;

public class EchoLoop implements Runnable {

    private Sokket sokket;
    private AppFactory factory;
    private Reader reader;
    private Writer writer;

    public EchoLoop(Sokket sokket, AppFactory factory) {
        this.sokket = sokket;
        this.factory = factory;
    }

    public void run() {
        try {
            setReaderAndWriter();
            runEchoLoop();
            closeReaderAndWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setReaderAndWriter() throws IOException {
        reader = factory.createReader(sokket.getInputStream());
        writer = factory.createWriter(sokket.getOutputStream());
    }

    private void runEchoLoop() throws IOException {
        String clientMessage = reader.readLine();
        while (!clientMessage.equals("exit!")) {
            writer.printLine(clientMessage);
            clientMessage = reader.readLine();
        }
    }

    private void closeReaderAndWriter() throws IOException {
        reader.close();
        writer.close();
    }

}
