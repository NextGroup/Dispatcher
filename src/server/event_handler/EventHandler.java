package server.event_handler;

import java.io.IOException;
import java.io.InputStream;

/**
 * @brief 이벤트 핸들러의 인터페이스.
 */
public interface EventHandler {
    /**
     * @brief 이벤트 핸들러의 키값을 반환한다.
     * @return HandleKey 특정 이벤트 핸들러의 키값
     */
    public String getHandle();

    /**
     * @brief 핸들러에 데이터를 파싱하여 처리한다.
     * @details '|' 를 기준으로 data1|data2|... 로 나누어서 처리한다.
     * @param data 핸들러가 파싱하여 처리할 스트림이다.
     * @return Nothing
     */
    public void handleEvent(InputStream data) throws IOException;
}