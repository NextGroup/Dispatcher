package server.event_handler;

/**
 * B 이벤트 핸들러.
 */
public class BEventHandler extends EventHandler {

    /**
     * B 이벤트 핸들러의 키값을 반환한다.
     * @param
     * @return HandleKey B 이벤트 핸들러의 키값.
     */
    public String getHandle() {
        return "0x6001";
    }

    /**
     * B 이벤트를 출력하는 서비스.
     * @param nation 나라.
     * @param city 도시.
     * @return Nothing
     */
    @Override
    public void printService(String nation, String city) {
        System.out.println("B Service print called...");
        System.out.println("Param -> nation :" + nation + " city : " + city);
    }
}
