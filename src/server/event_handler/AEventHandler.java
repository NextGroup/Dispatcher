package server.event_handler;

/**
 * A 이벤트 핸들러.
 */
public class AEventHandler extends EventHandler {

    /**
     * A 이벤트 핸들러의 키값을 반환한다.
     * @param
     * @return HandleKey A 이벤트 핸들러의 키값.
     */
    public String getHandle() {
        return "0x5001";
    }

    /**
     * A 이벤트를 출력하는 서비스.
     * @param name 이름.
     * @param age 나이.
     * @return Nothing
     */
    @Override
    public void printService(String name, String age) {
        System.out.println("A Service print called...");
        System.out.println("Param -> name :" + name + " age : " + age);
    }
}
