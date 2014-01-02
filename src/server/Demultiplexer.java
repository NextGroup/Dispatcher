package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 이벤트가 발생가 발생할 때, 이벤트를 디코딩하여 적절한 핸들러에 전달한다.
 */
public class Demultiplexer {
    private ServerSocket serverSocket;

    /**
     * 생성자. 서버 소켓을 생성한다.
     * @param
     * @throws IOException
     * @return Nothing
     */
    public Demultiplexer() throws IOException {
        serverSocket = new ServerSocket(5000);
    }

    /**
     * 이벤트가 발생할 때, header / data 만 나눠주는 parsing(decoding)역할을 하는 거지. 
     * @param handlers Reactor에 등록된 핸들맵 객체.
     * @throws IOException
     * @return Nothing
     */
    public void select(HandleMap handlers) throws IOException {
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[6];
        //byte[] buffer = new byte[HeaderSize];로 바꾸렴. 
        
        inputStream.read(buffer);
        String header = new String(buffer);

        buffer = new byte[1024];
        inputStream.read(buffer);
        String body = new String(buffer);

        handlers.get(header).handleEvents(body);
    }
}

