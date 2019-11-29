package mocks;

import echoServer.interfaces.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MockAppFactory implements AppFactory {

    private ServerSokket serverSokket;
    private boolean createdServerSokket = false;



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


    private Thread thread;
    private int callCountForCreateThreadFor = 0;
    public int getCallCountForCreateThreadFor() {
        return callCountForCreateThreadFor;
    }



    private Reader reader;
    public void setReaderToReturn(Reader reader) {
        this.reader = reader;
    }
    private int callCountForCreateReader = 0;
    public int getCallCountForCreateReader() {
        return callCountForCreateReader;
    }

    private Writer writer;
    public void setWriterToReturn(Writer writer) {
        this.writer = writer;
    }
    private int callCountForCreateWriter = 0;
    public int getCallCountForCreateWriter() {
        return callCountForCreateWriter;
    }

    ClientProtocol welcomer;
    public void setWelcomerToReturn(ClientProtocol welcomer) {
        this.welcomer = welcomer;
    }
    private int callCountForCreateWelcome = 0;
    public int getCallCountForCreateWelcome() {
        return callCountForCreateWelcome;
    }

    private ClientProtocol echoLoop;
    public void setEchoLoopToReturn(ClientProtocol echoLoop) {
        this.echoLoop = echoLoop;
    }
    private int callCountForCreateEchoLoopProtocol = 0;
    public int getCallCountForCreateEchoLoopProtocol() {
        return callCountForCreateEchoLoopProtocol;
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
        callCountForCreateReader += 1;
        return reader;
    }

    @Override
    public Writer createWriter(OutputStream outputStream) {
        callCountForCreateWriter += 1;
        return writer;
    }

    @Override
    public Runnable createEchoLoopInit(Sokket connectedSokket, AppFactory factory) {
        callCountForCreateEchoLoopInit += 1;
        return null;
    }

    @Override
    public ClientProtocol createWelcome(Writer writer) {
        callCountForCreateWelcome += 1;
        return welcomer;
    }

    // return null works!!

    @Override
    public ClientProtocol createEchoLoop(Reader reader, Writer writer) {
        callCountForCreateEchoLoopProtocol += 1;
        return echoLoop;
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


//    public boolean createdReader() {
//        return createdReader;
//    }




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
