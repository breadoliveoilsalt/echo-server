import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class JavaSocketWrapper implements Sokket {

    private Socket socket;

    public JavaSocketWrapper(Socket socket) {
        this.socket = socket;
    }

    public void sendToOutputStream(String message) throws IOException {
        new PrintWriter(socket.getOutputStream(), true).println(message);
    }

    public void close() throws IOException {
        socket.close();
    }
}
