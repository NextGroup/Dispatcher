package server.event_handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 * @brief SayHello 이벤트를 처리할 핸들러.
 * @details 데이터를 파싱하여 이름과 나이를 출력한다.
 */
public class SayHelloEventHandler implements EventHandler {
    private static final int DATA_SIZE = 512;
    private static final int TOKEN_NUM = 2;

    /**
     * @brief SayHello이벤트 핸들러의 키값을 반환한다.
     * @return HandleKey SayHello이벤트 핸들러의 키값.
     */
    public String getHandle() {
        return "0x5001";
    }

    /**
     * @brief 데이터를 파싱하여 처리한다.
     * @details '|' 를 기준으로 |name|age| 로 나누어서 처리한다.
     * @param data 핸들러가 파싱하여 처리할 스트림이다.
     * @return Nothing
     * @throws java.io.IOException IOException 발생시 던진다.
     */
    public void handleEvent(InputStream data) throws IOException{
        byte[] buffer = new byte[DATA_SIZE];
        data.read(buffer);

        String str = new String(buffer);
        String[] params = new String[TOKEN_NUM];

        StringTokenizer token = new StringTokenizer(str, "|");
        int i = 0;
        while (token.hasMoreTokens())
            params[i++] = token.nextToken();

        sayHello(params);
    }

    /**
     * @brief 파라미터를 출력한다.
     * @details 이름, 나이를 출력한다.
     * @param params sayHello할 파라미터. 이름, 나이 정보가 있다.
     * @return Nothing
     */
    public void sayHello(String[] params) {
        System.out.println("SayHello -> name : " + params[0] + " age : " + params[1]);
    }
}
