package server.event_handler;

import java.util.StringTokenizer;

/**
 * @author dongkuk
 * 이벤트 핸들러를 정의하는 추상클래스.
 *
 */
public abstract class EventHandler {
    /**
     * @param params
     * @return Nothing
     * 전달된 이벤트를 처리한다.
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
     * @param
     * @return HandleKey
     * 특정 이벤트 핸들러의 키값을 반환하는 추상메서드.
     */
    public abstract String getHandle();

    /**
     * @param str1
     * @param str2
     * @return Nothing
     * 특정 이벤트를 출력하는 콜백메서드.
     */
    public abstract void printService(String str1, String str2);
}