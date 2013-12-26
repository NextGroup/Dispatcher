package server;

import server.event_handler.AEventHandler;
import server.event_handler.BEventHandler;

import java.io.IOException;

/**
 * @author dongkuk
 * 서버 초기화 클래스
 */
public class ServerInitialize {
    /**
     * @param args
     * @return Nothing
     * Reactor를 초기화하고 이벤트 핸들러를 등록한다.
     * Reactor에 이벤트 핸들링 메세지를 전달한다.
     */
    public static void main(String[] args) {
        // Reactor 초기화

        Reactor reactor = new Reactor();

        // Reactor에 핸들러 등록
        reactor.registerHandler(new AEventHandler());
        reactor.registerHandler(new BEventHandler());

        // Reactor에 이벤트 핸들링 메세지
        try {
            reactor.handle_events();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
