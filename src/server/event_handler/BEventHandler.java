package server.event_handler;

/**
 * @author dongkuk
 * B 이벤트 핸들러
 */
public class BEventHandler extends EventHandler {

    /**
     * @param
     * @return HandleKey
     * B 이벤트 핸들러의 키값을 반환한다.
     */
    public String getHandle() {
        return "0x6001";
    }

    /**
     * @param nation
     * @param city
     * @return Nothing
     * B 이벤트를 출력하는 서비스.
     */
    @Override
    public void printService(String nation, String city) {
        System.out.println("B Service print called...");
        System.out.println("Param -> nation :" + nation + " city : " + city);
    }
}
