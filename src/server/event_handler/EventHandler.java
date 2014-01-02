package server.event_handler;

import java.util.StringTokenizer;

/**
 * 이벤트 핸들러를 정의하는 추상클래스.
 */
public abstract class EventHandler {
    
    /**
     * 메소드가 do / execute 로 바뀔 껏. 
     * @brief 핸들러에 전달된 이벤트를 파싱하여 처리한다.
    * @param params 핸들러가 파싱하여 처리할 문자열이다.  '|' 를 기준으로 data1|data2 로 나누어서 처리한다.  
     * @return Nothing
     */
    public void handleEvents(String params) {
        String[] arr = new String[2];

        StringTokenizer token = new StringTokenizer(params, "|");
        int i = 0;
        while (token.hasMoreTokens())
            arr[i++] = token.nextToken();

        String str1 = arr[0];
        String str2 = arr[1];

        printService(str1, str2);


        //handlers.get(header).handleEvents(body);

    }

    /**
     * 특정 이벤트 핸들러의 키값을 반환하는 추상메서드.
     * @return HandleKey 특정 이벤트 핸들러의 키값
     */
    public abstract String getHandle();

    /*
     * @breif 특정 이벤트를 출력하는 콜백메서드.
     * @detail Event Handler를 상속받는 클래스는 
     * @param str1 출력할 문자열 객체1
     * @param str2 출력할 문자열 객체2
     * @return Nothing
     */
    public abstract void printService(String str1, String str2);
}