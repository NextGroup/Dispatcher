package server.event_handler;

/**
 * B 이벤트 핸들러. -> 핸들러 이름을 변경하자 UpdateProfileInfo (id, pw, name, gender, email, address, mobilenum, age)
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
     * @description 사용자의 정보를 업데이트하는 이벤트 핸들러
     * @param nation 나라.  -> parameter를 byte[]로 받아와라
     * @param city 도시.
     * @return Nothing
     */
    @Override
    public void printService(String nation, String city) {
        System.out.println("B Service print called...");
        System.out.println("Param -> nation :" + nation + " city : " + city);



        //UserCtrl.UpdatePofileInfo(id,pw,name,gender... ,)
  
    }
}
