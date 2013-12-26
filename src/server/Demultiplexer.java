package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dongkuk
 * 이벤트가 발생하면 디코딩한다.
 */
public class Demultiplexer {
    private ServerSocket serverSocket;

    /**
     * @param
     * @throws IOException
     * @return Nothing
     * 디멀티플렉서 생성자
     * 서버 소켓을 생성한다.
     */
    public Demultiplexer() throws IOException {
        serverSocket = new ServerSocket(5000);
    }

    /**
     * @param handlers
     * @throws IOException
     * @return Nothing
     * 이벤트가 발생하면 디코딩한다.
     */
    public void select(HandleMap handlers) throws IOException {
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[6];
        inputStream.read(buffer);
        String header = new String(buffer);

        buffer = new byte[1024];
        inputStream.read(buffer);
        String body = new String(buffer);

        handlers.get(header).handleEvents(body);
    }
}