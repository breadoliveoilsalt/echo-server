package echoServer.logic;

import echoServer.interfaces.AppFactory;
import echoServer.interfaces.ServerSokket;
import echoServer.interfaces.ServerSokketProtocol;

import java.io.IOException;

public class EchoServerInit {

    private int port;
    private ServerSokketProtocol protocol;
    private AppFactory factory;
    private ServerSokket serverSokket;

    public EchoServerInit(int port, ServerSokketProtocol protocol, AppFactory factory) {
        this.port = port;
        this.protocol = protocol;
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
        protocol.run(serverSokket, factory);
    }

    private void closeServerSokket() throws IOException {
        serverSokket.close();
    }

    public ServerSokket getServerSokket() {
        return serverSokket;
    }

}
