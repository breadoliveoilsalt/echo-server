package mocks;

import echoServer.interfaces.ConnectionProtocol;
import echoServer.interfaces.Sokket;

public class MockConnectionProtocol implements ConnectionProtocol {

    private Sokket connectedSokket;

    public void handleConnection(Sokket sokket) {
        connectedSokket = sokket;
    }

    public Sokket getConnectedSokket() {
       return connectedSokket;
    }

}
