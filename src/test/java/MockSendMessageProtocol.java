public class MockSendMessageProtocol extends ConnectionProtocol {

    private Sokket connectedSokket;

    @Override
    public void handleConnection(Sokket sokket) {
        connectedSokket = sokket;
    }

    public Sokket getConnectedSokket() {
       return connectedSokket;
    }

}
