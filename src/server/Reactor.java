package server;

import server.event_handler.EventHandler;

import java.io.IOException;

/**
 * @author dongkuk
 * EventHandler를 관리하는 객체
 * 이벤트 디코딩하여 적절한 핸들러에 분배한다.
 */
public class Reactor {
    private HandleMap handlers;

    /**
     * @param
     * @return Nothing
     */
    public Reactor() {
        handlers = new HandleMap();
    }

    /**
     * @param
     * @throws IOException
     * @return Nothing
     * 이벤트를 디코딩한 후, 적절한 핸들러에 분배한다.
     */
    public void handle_events() throws IOException {
        Demultiplexer demultiplexer = new Demultiplexer();
        while (true) {
            demultiplexer.select(handlers);
        }
    }

    /**
     * @param handler
     * @return Nothing
     * Reactor에 이벤트 핸들러를 등록한다.
     */
    public void registerHandler(EventHandler handler) {
        handlers.put(handler.getHandle(), handler);
    }

    /**
     * @param handler
     * @return Nothing
     * Reactor에 이벤트 핸들러를 제거한다.
     */
    public void removeHandler(EventHandler handler) {
        handlers.remove(handler.getHandle());
    }
}