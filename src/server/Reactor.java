package server;

import server.event_handler.AEventHandler;
import server.event_handler.BEventHandler;
import server.event_handler.EventHandler;

import java.io.IOException;

public class Reactor {
    private Handle handlers;

    public Reactor() {
        handlers = new Handle();
    }

    public void handle_events() throws IOException {
        // 이벤트 분해 후 핸들링
        Demux demux = new Demux();
        while (true) {
            demux.select(handlers);
        }
    }

    // 핸들러 등록
    public void registerHandler(EventHandler handler) {
        handlers.put(handler.getHandle(), handler);
    }

    // 핸들러 제거
    public void removeHandler(EventHandler handler) {
        handlers.remove(handler.getHandle());
    }

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

// 1. javadoc 또는 doxygen

// 2. 엔트리 포인트 클래스 또는 팩토리 객체로 메인문 추출하기
// ServerInitialize 클래스라는 네이밍

// 나중에(3. log4j 사용)