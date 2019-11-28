package echoServer.logic;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class EchoServer {

    private int port;
    private ServerSokketProtocol serverProtocol;
    private AppFactory factory;
    private ServerSokket serverSokket;

    public EchoServer(int port, ServerSokketProtocol serverProtocol, AppFactory factory) {
        this.port = port;
        this.serverProtocol = serverProtocol;
        this.factory = factory;
    }

    public void start() throws IOException {

        try {
            initializeServerSokket();
            runServerSokketProtocol();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeServerSokket();
        }

    }

    private void initializeServerSokket() throws IOException {
        serverSokket = factory.createServerSokketListeningAtPort(port);
    }

    private void runServerSokketProtocol() throws IOException {
        serverProtocol.run(serverSokket, factory);
    }

    private void closeServerSokket() throws IOException {
        serverSokket.close();
    }

    public ServerSokket getServerSokket() {
        return serverSokket;
    }

}
