package server.event_handler;

/**
 * @author dongkuk
 * A 이벤트 핸들러
 */
public class AEventHandler extends EventHandler {

    /**
     * @param
     * @return HandleKey
     * A 이벤트 핸들러의 키값을 반환한다.
     */
    public String getHandle() {
        return "0x5001";
    }

    /**
     * @param name
     * @param age
     * @return Nothing
     * A 이벤트를 출력하는 서비스
     */
    @Override
    public void printService(String name, String age) {
        System.out.println("A Service print called...");
        System.out.println("Param -> name :" + name + " age : " + age);
    }
}
