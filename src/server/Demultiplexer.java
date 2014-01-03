package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @brief 이벤트를 디코딩하여 적절한 핸들러에 전달한다.
 * @details 이벤트가 발생하면 header와 data 부분으로 나눈다. 이중 header는 적절한 handler를 찾는데 쓰이고, data는 handler에 전달한다.
 */
public class Demultiplexer {
    private ServerSocket serverSocket;
    private final int HEADER_SIZE = 6;

    /**
     * @brief 생성자.
     * @details 서버 소켓을 생성한다.
     * @return Nothing
     * @throws IOException IOException 발생시 던진다.
     */
    public Demultiplexer() throws IOException {
        serverSocket = new ServerSocket(5000);
    }

    /**
     * @brief 이벤트 발생시 Demultiplex 한다.
     * @details 이벤트 발생시, header와 data로 나눈다. 이중 header는 적절한 handler를 찾는데 쓰이고, data는 handler에 전달한다.
     * @param handlers Reactor에 등록된 핸들맵 객체.
     * @return Nothing
     * @throws IOException IOException 발생시 던진다.
     */
    public void select(HandleMap handlers) throws IOException {
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[HEADER_SIZE];
        inputStream.read(buffer);
        String header = new String(buffer);

        handlers.get(header).handleEvent(inputStream);
    }
}

