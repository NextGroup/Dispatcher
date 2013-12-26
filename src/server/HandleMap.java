package server;

import server.event_handler.EventHandler;

import java.util.HashMap;

/**
 * @author dongkuk
 * HandleKey와 이벤트 핸들러를 해쉬 형태로 저장하는 객체.
 */
public class HandleMap extends HashMap<String, EventHandler> {
}