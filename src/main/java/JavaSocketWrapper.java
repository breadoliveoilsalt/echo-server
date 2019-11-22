import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class JavaSocketWrapper implements Sokket {

    private Socket socket;

    public JavaSocketWrapper(Socket socket) {
        this.socket = socket;
    }

    public void sendToOutputStream(String message) throws IOException {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println(message);
        } catch (IOException ignored) { }
    }

    public String readLine() throws IOException {
        String clientMessage = null;

        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())) ) {
            clientMessage = reader.readLine();
        } catch (IOException ignored) { }

        return clientMessage;
    }

    public void close() throws IOException {
        socket.close();
    }
}
