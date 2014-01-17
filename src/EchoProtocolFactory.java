import java.net.Socket;

/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @editor Dongkuk Kim, dongkuk5411@nhnnext.org
 * @version 0.0.1
 * @brief 에코 프로토콜을 생성하는 팩토리 클래스
 * @details 클라이언트의 요청을 처리할 에코 프로토콜 클래스를 생성한다.
 * @date 2014-01-16
 */
public class EchoProtocolFactory implements ProtocolFactory {

    /**
     * @param clntSock 클라이언트 소켓
     * @param logger 로거
     * @return 쓰레드로 동작하는 객체
     * @brief 에코 프로토콜 팩토리의 생성자.
     * @details 클라이언트의 요청을 처리할 에코 프로토콜 클래스를 생성한다.
     */
    public Runnable createProtocol(Socket clntSock, Logger logger) {
        return new EchoProtocol(clntSock, logger);
    }
}
