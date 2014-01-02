package server.event_handler;

import java.util.StringTokenizer;

/**
 * 이벤트 핸들러를 정의하는 추상클래스.
 */
public abstract class EventHandler {
    /**
     * 핸들러에 전달된 이벤트를 파싱하여 처리한다.
     * @param params 핸들러가 파싱하여 처리할 문자열.
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
    }

    /**
     * 특정 이벤트 핸들러의 키값을 반환하는 추상메서드.
     * @param
     * @return HandleKey 특정 이벤트 핸들러의 키값
     */
    public abstract String getHandle();

    /**
     * 특정 이벤트를 출력하는 콜백메서드.
     * @param str1 출력할 문자열 객체1
     * @param str2 출력할 문자열 객체2
     * @return Nothing
     */
    public abstract void printService(String str1, String str2);
}