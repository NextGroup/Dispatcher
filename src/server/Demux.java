package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demux {
    private ServerSocket serverSocket;

    // 서버 소켓 생성
    public Demux() throws IOException {
        serverSocket = new ServerSocket(5000);
    }

    // 이벤트 분해 후 핸들러에 전달
    public void select(Handle handlers) throws IOException {
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

// Demultiplexer로 변경
