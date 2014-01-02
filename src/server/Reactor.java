package server;

import server.event_handler.EventHandler;

import java.io.IOException;

/**
 * 이벤트 핸들러를 관리하는 객체.
 */
public class Reactor {
    private HandleMap handlers;

    /**
     * Reactor 생성자. 핸들과 이벤트 핸들러를 관리할 핸들맵을 초기화한다.
     * @param
     * @return Nothing
     */
    public Reactor() {
        handlers = new HandleMap();
    }

    /**
     * 디멀티플렉서에 select 명령을 한다.
     * @param
     * @throws IOException
     * @return Nothing
     */
    public void handle_events() throws IOException {
        Demultiplexer demultiplexer = new Demultiplexer();
        while (true) {
            demultiplexer.select(handlers);
        }
    }

    /**
     * Reactor에 이벤트 핸들러를 등록한다.
     * @param handler 특정 이벤트를 처리할 핸들러
     * @return Nothing
     */
    public void registerHandler(EventHandler handler) {
        handlers.put(handler.getHandle(), handler);
    }

    /**
     * Reactor에 이벤트 핸들러를 제거한다.
     * @param handler 특정 이벤트를 처리할 핸들러
     * @return Nothing
     */
    public void removeHandler(EventHandler handler) {
        handlers.remove(handler.getHandle());
    }
}