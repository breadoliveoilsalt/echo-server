import java.io.*;
import java.net.Socket;

public class JavaSocketWrapper implements Sokket {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public JavaSocketWrapper(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendToOutputStream(String message) {
        writer.println(message);
    }

    public String readLine() throws IOException {
       return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }

}
