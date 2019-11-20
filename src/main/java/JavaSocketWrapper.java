import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class JavaSocketWrapper extends Sokket {

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
