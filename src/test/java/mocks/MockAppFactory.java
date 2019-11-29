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

    private Runnable echoLoopInit;

    public void setEchoLoopInitToReturn(Runnable echoLoop) {
        this.echoLoopInit = echoLoopInit;
    }

    public Runnable getEchoLoopInit() {
        return echoLoopInit;
    }

    private int callCountForCreateEchoLoopInit = 0;

    public int getCallCountForCreateEchoLoopInit() {
        return callCountForCreateEchoLoopInit;
    }

    private ClientProtocol echoLoop;

    private int callCountForCreateThreadFor = 0;

    public int getCallCountForCreateThreadFor() {
        return callCountForCreateThreadFor;
    }

    private Thread thread;

    public boolean isCreatedWriter() {
        return createdWriter;
    }

    @Override
    public ServerSokket createServerSokketListeningAtPort(int port) throws IOException {
        createdServerSokket = true;
        return serverSokket;
    }

    public void setServerSokketToReturn(ServerSokket serverSokket) {
        this.serverSokket = serverSokket;
    }

    public ServerSokket getServerSokket() {
        return serverSokket;
    }

    @Override
    public Reader createReader(InputStream inputStream) {
        createdReader = true;
        return null;
//        return reader;
    }

    @Override
    public Writer createWriter(OutputStream outputStream) {
        createdWriter = true;
//        return writer;
        return null;
    }

    @Override
    public Runnable createEchoLoopInit(Sokket connectedSokket, AppFactory factory) {
        callCountForCreateEchoLoopInit += 1;
//        return echoLoopInit;
        return null;
    }

    @Override
    public ClientProtocol createWelcome(Writer writer) {
        return null;
    }

    // return null works!!

    @Override
    public ClientProtocol createEchoLoopProtocol(Reader reader, Writer writer) {
        return null;
    }

    @Override
    public Thread createThreadFor(Runnable runnable) {
        callCountForCreateThreadFor += 1;
        return thread;
    }

    public boolean createdServerSokket() {
        return createdServerSokket;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReaderToReturn(Reader reader) {
        this.reader = reader;
    }

    public boolean createdReader() {
        return createdReader;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriterToReturn(Writer writer) {
        this.writer = writer;
    }

    public boolean createdWriter() {
        return createdWriter;
    }



//    public boolean createdEchoLoop() {
//        return createdEchoLoop;
//    }

    public Thread getThread() {
        return thread;
    }

    public void setThreadToReturn(Thread thread) {
        this.thread = thread;
    }

//    public boolean createdThread() {
//        return createdThread;
//    }

}
