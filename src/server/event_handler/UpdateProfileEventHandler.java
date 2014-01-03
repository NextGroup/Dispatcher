package server.event_handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 * @brief UpdateProfile 이벤트를 처리할 핸들러.
 * @details 데이터를 파싱하여 아이디, 패스워드, 이름, 나이, 성별을 출력한다.
 */
public class UpdateProfileEventHandler implements EventHandler {
    private static final int DATA_SIZE = 1024;
    private static final int TOKEN_NUM = 5;

    /**
     * @brief UpdateProfile이벤트 핸들러의 키값을 반환한다.
     * @return HandleKey UpdateProfile이벤트 핸들러의 키값.
     */
    public String getHandle() {
        return "0x6001";
    }

    /**
     * @brief 데이터를 파싱하여 처리한다.
     * @details '|' 를 기준으로 |id|password|name|age|gender| 로 나누어서 처리한다.
     * @param data 핸들러가 파싱하여 처리할 스트림이다.
     * @return Nothing
     * @throws java.io.IOException IOException 발생시 던진다.
     */
    public void handleEvent(InputStream data) throws IOException {
        byte[] buffer = new byte[DATA_SIZE];
        data.read(buffer);

        String str = new String(buffer);
        String[] params = new String[TOKEN_NUM];

        StringTokenizer token = new StringTokenizer(str, "|");
        int i = 0;
        while (token.hasMoreTokens())
            params[i++] = token.nextToken();

        updateProfile(params);
    }

    /**
     * @brief 파라미터를 출력한다.
     * @param params updateProfile할 파라미터. 아이디, 패스워드, 이름, 나이, 성별 정보가 있다.
     * @return Nothing
     * @description 사용자의 정보를 업데이트하는 이벤트 핸들러
     */
    public void updateProfile(String[] params) {
        System.out.println("UpdateProfile -> " +
                " id :" + params[0] +
                " password : " + params[1] +
                " name : " + params[2] +
                " age : " + params[3] +
                " gender: " + params[4]);
    }
}
