package protocol;

import logger.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @version 0.0.1
 * @brief 에코 프로토콜을 처리하는 클래스
 * @details 클라이언트의 요청과 똑같은 내용을 전송한다.
 * @date 2014-01-16
 */
public class EchoProtocol implements Runnable {
    static public final int BUFSIZE = 32;

    private Socket clntSock;
    private Logger logger;


    /**
     * @param clntSock 클라이언트 소켓
     * @param logger 로그 클래스
     * @brief 에코 프로토콜의 생성자
     * @details 클라이언트의 요청을 처리할 에코 프로토콜 객체를 생성한다.
     */
    public EchoProtocol(Socket clntSock, Logger logger) {
        this.clntSock = clntSock;
        this.logger = logger;
    }

    /**
     * @brief 클라이언트의 요청과 똑같은 내용을 전송하는 메서드
     * @details 클라이언트의 요청과 똑같은 내용을 다시 전달하는 에코 메서드이다.
     */
    public void run() {
        ArrayList entry = new ArrayList();
        entry.add("Client address and port = " +
                clntSock.getInetAddress().getHostAddress() + ":" +
                clntSock.getPort());
        entry.add("Thread = " + Thread.currentThread().getName());

        try {
            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();

            int recvMsgSize;
            int totalBytesEchoed = 0;
            byte[] echoBuffer = new byte[BUFSIZE];

            while ((recvMsgSize = in.read(echoBuffer)) != -1) {
                out.write(echoBuffer, 0, recvMsgSize);
                totalBytesEchoed += recvMsgSize;
            }

            entry.add("Client finished; echoed " + totalBytesEchoed + " bytes.");
        } catch (IOException e) {
            entry.add("Exception = " + e.getMessage());
        }

        try {
            clntSock.close();
        } catch (IOException e) {
            entry.add("Exception = " + e.getMessage());
        }

        logger.writeEntry(entry);
    }
}
