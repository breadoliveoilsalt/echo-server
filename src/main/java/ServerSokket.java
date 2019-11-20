public abstract class ServerSokket {

    abstract ServerSokket createAndListenAtPort();

    abstract Sokket acceptConnectionAndReturnConnectedSocket();

}
