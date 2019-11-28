package mocks;

import echoServer.interfaces.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MockAppFactory implements AppFactory {


    private ServerSokket serverSokket;
    private boolean createdServerSokket = false;

    private Reader reader;
    private boolean createdReader = false;

    private Writer writer;
    private boolean createdWriter = false;

    private Runnable echoLoop;
    private boolean createdEchoLoop = false;

    private Thread thread;
    private boolean createdThread = false;

    @Override
    public ServerSokket createServerSokketListeningAtPort(int port) throws IOException {
        createdServerSokket = true;
        return serverSokket;
    }

    @Override
    public Reader createReader(InputStream inputStream) {
        createdReader = true;
        return reader;
    }

    @Override
    public Writer createWriter(OutputStream outputStream) {
        createdWriter = true;
        return writer;
    }

    @Override
    public Runnable createEchoLoop(Sokket connectedSokket, AppFactory factory) {
        createdEchoLoop = true;
        return echoLoop;
    }

    @Override
    public Thread createThreadFor(Runnable runnable) {
        createdThread = true;
        return thread;
    }

    public ServerSokket getServerSokket() {
        return serverSokket;
    }

    public void setServerSokket(ServerSokket serverSokket) {
        this.serverSokket = serverSokket;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Runnable getEchoLoop() {
        return echoLoop;
    }

    public void setEchoLoop(Runnable echoLoop) {
        this.echoLoop = echoLoop;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
