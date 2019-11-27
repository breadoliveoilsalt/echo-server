package echoServer.wrappers;

import echoServer.interfaces.Sokket;

import java.io.*;
import java.net.Socket;

public class JavaSocketWrapper implements Sokket {

    private Socket socket;

    public JavaSocketWrapper(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }

    public void close() throws IOException {
        socket.close();
    }

}
