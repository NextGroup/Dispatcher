package server;

import server.event_handler.SayHelloEventHandler;
import server.event_handler.UpdateProfileEventHandler;

import java.io.IOException;

/**
 * @brief 서버 초기화 클래스
 * @details 서버를 초기화하고 Reactor에 이벤트 핸들러를 등록한다.
 */
public class ServerInitialize {
    private Reactor reactor;

    /**
     * @brief Reactor를 실행한다.
     * @details Reactor를 초기화하고 이벤트 핸들러를 등록한다. Reactor에 이벤트 핸들링을 명령한다.
     * @return Nothing
     * @exception java.io.IOException 서버 소켓에서 IO 에러 발생 가능.
     */
    private void dispatch() {
        reactor = new Reactor();

        reactor.registerHandler(new SayHelloEventHandler());
        reactor.registerHandler(new UpdateProfileEventHandler());

        try {
            reactor.handle_events();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief 메인 구문
     * @details Server를 초기화하고 Reactor에 전달한다.
     * @param args 기본 콘솔 변수
     * @return Nothing
     */
    public static void main(String[] args) {
        ServerInitialize serverInitialize = new ServerInitialize();
        serverInitialize.dispatch();
    }
}
