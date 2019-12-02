package mocks;

import echoServer.interfaces.*;

import java.io.InputStream;
import java.io.OutputStream;

public class MockAppFactory implements AppFactory {

    private ServerSokket serverSokket;
    public void setServerSokketToReturn(ServerSokket serverSokket) {
        this.serverSokket = serverSokket;
    }
    private int callCountForCreateServerSokket = 0;
    public int getCallCountForCreateServerSokket() {
        return callCountForCreateServerSokket;
    }

    private Runnable echoLoopInit;
    public void setEchoLoopInitToReturn(Runnable echoLoopInit) {
        this.echoLoopInit = echoLoopInit;
    }
    private int callCountForCreateEchoLoopInit = 0;
    public int getCallCountForCreateEchoLoopInit() {
        return callCountForCreateEchoLoopInit;
    }

    private Thread thread;
    public void setThreadToReturn(Thread thread) {
        this.thread = thread;
    }
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

    private ClientProtocol welcomer;
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
    private int callCountForCreateEchoLoop = 0;
    public int getCallCountForCreateEchoLoop() {
        return callCountForCreateEchoLoop;
    }

    @Override
    public ServerSokket createServerSokketListeningAtPort(int port) {
        callCountForCreateServerSokket += 1;
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
        return echoLoopInit;
    }

    @Override
    public ClientProtocol createWelcome(Writer writer) {
        callCountForCreateWelcome += 1;
        return welcomer;
    }

    @Override
    public ClientProtocol createEchoLoop(Reader reader, Writer writer) {
        callCountForCreateEchoLoop += 1;
        return echoLoop;
    }

    @Override
    public Thread createThreadFor(Runnable runnable) {
        callCountForCreateThreadFor += 1;
        return thread;
    }

}
