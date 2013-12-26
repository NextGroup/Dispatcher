package server.event_handler;

import java.util.StringTokenizer;

public abstract class EventHandler {
    // 메세지 분해
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

    // 지금은 적절한 이벤트 핸들러를 찾아가는 key값이 핸들입니다.
    public abstract String getHandle();

    // 콜백 메서드 입니다.
    public abstract void printService(String str1, String str2);
}