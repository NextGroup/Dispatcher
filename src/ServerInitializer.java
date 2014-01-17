import dispatcher.Dispatcher;
import logger.ConsoleLogger;
import logger.Logger;
import protocol.EchoProtocolFactory;
import protocol.ProtocolFactory;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @editor Dongkuk Kim, dongkuk5411@nhnnext.org
 * @version 0.0.1
 * @brief 서버가 시작하는 클래스
 * @details 소켓, 로거, 프로토콜 팩토리를 디스패처에 전달한다.
 * @date 2014-01-16
 */
public class ServerInitializer {

    /**
     * @param args 포트번호, 프로토콜명, 디스패처명이 있는 콘솔 입력 함수
     * @throws Exception
     * @brief 메인 메서드
     * @details 콘솔에서 포트번호, 프로토콜명, 디스패처명을 입력받아 적절한 소켓, 프로토콜팩토리, 디스패처를 생성한다.
     */
    public static void main(String[] args) throws Exception {

        if (args.length != 3)
            throw new IllegalArgumentException("Parameter(s): [<Optional properties>]"
                    + " <Port> <Protocol> <Dispatcher>");

        int servPort = Integer.parseInt(args[0]);
        String protocolName = args[1];
        String dispatcherName = args[2];

        ServerInitializer serverInitializer = new ServerInitializer();
        serverInitializer.initializeServer(servPort, protocolName, dispatcherName);
    }

    public void initializeServer(int servPort, String protocolName, String dispatcherName)
            throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        ServerSocket servSock = new ServerSocket(servPort);
        Logger logger = new ConsoleLogger();

        ProtocolFactory protoFactory = (ProtocolFactory)
                Class.forName(protocolName + "ProtocolFactory").newInstance();

        Dispatcher dispatcher = (Dispatcher)
                Class.forName(dispatcherName + "Dispatcher").newInstance();

        dispatcher.startDispatching(servSock, logger, protoFactory);
    }
}
