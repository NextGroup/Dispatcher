package dispatcher;

import logger.Logger;
import protocol.ProtocolFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @editor Dongkuk Kim, dongkuk5411@nhnnext.org
 * @version 0.0.1
 * @brief 디스패칭 시에 쓰레드를 할당하는 디스패처 클래스
 * @details 클라이언트의 요청을 받은 후 쓰레드를 할당하여 이벤트를 처리하는 디스패처이다.
 * @date 2014-01-16
 */
public class ThreadPerDispatcher implements Dispatcher {

    /**
     * @param servSock     서버 소켓 클래스
     * @param logger       로그 남기는 클래스
     * @param protoFactory 프로토콜 생성 클래스
     * @brief 디스패칭하는 메서드
     * @details 클라이언트의 요청을 받으면 쓰레드를 추가로 생성하고 적절한 프로토콜 클래스에 이벤트 처리 작업을 넘긴다.
     */
    public void startDispatching(ServerSocket servSock, Logger logger,
                                 ProtocolFactory protoFactory) {
        for (; ; ) {
            try {
                Socket clntSock = servSock.accept();
                Runnable protocol = protoFactory.createProtocol(clntSock, logger);
                Thread thread = new Thread(protocol);
                thread.start();
                logger.writeEntry("Created and started Thread = " + thread.getName());
            } catch (IOException e) {
                logger.writeEntry("Exception = " + e.getMessage());
            }
        }
    }
}
