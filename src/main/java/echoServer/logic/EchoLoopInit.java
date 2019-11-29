package echoServer.logic;

import echoServer.interfaces.*;

import java.io.IOException;

public class EchoLoopInit implements Runnable {

    private Sokket sokket;
    private AppFactory factory;
    private Reader reader;
    private Writer writer;

    public EchoLoopInit(Sokket sokket, AppFactory factory) {
        this.sokket = sokket;
        this.factory = factory;
    }

    public void run() {
        try {
            initReaderAndWriter();
            welcomeClient();
            runEchoLoop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReaderAndWriter();
        }
    }

    private void initReaderAndWriter() throws IOException {
        reader = factory.createReader(sokket.getInputStream());
        writer = factory.createWriter(sokket.getOutputStream());
    }

    private void welcomeClient() {
        ClientProtocol welcomer = factory.createWelcomer(writer);
        welcomer.printWelcome();
    }

    private void runEchoLoop() {
        ClientProtocol echoLoop = factory.createEchoLoopProtocol(reader, writer);
        echoLoop.run();

    }

    private void closeReaderAndWriter() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
