package server;

import server.event_handler.AEventHandler;
import server.event_handler.BEventHandler;

import java.io.IOException;

/**
 * 서버 초기화 클래스
 */
public class ServerInitialize {
    private Reactor reactor;

    /**
     * Reactor를 초기화하고 이벤트 핸들러를 등록한다. Reactor에 이벤트 핸들링을 명령한다.
     * @return Nothing
     */
    private void dispatch() {
        reactor = new Reactor();

        reactor.registerHandler(new AEventHandler());
        reactor.registerHandler(new BEventHandler());

        try {
            reactor.handle_events();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 메인 구문. server를 초기화한다.
     * @param args 기본 변수 
     */
    public static void main(String[] args) {
        ServerInitialize serverInitialize = new ServerInitialize();
        serverInitialize.dispatch();
    }
}
