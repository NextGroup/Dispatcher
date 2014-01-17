import java.util.Collection;
import java.util.Iterator;

/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @editor Dongkuk Kim, dongkuk5411@nhnnext.org
 * @version 0.0.1
 * @brief 콘솔에 로그남기는 클래스
 * @details 콘솔에 로그를 직접 쓰는 로거 클래스이다.
 * @date 2014-01-16
 */
public class ConsoleLogger implements Logger {

    /**
     * @brief 배열을 출력하는 메서드
     * @details 배열을 입력받아 배열에 있는 인자들을 콘솔에 출력한다.
     * @param entry 출력하고 싶은 내용이 들어있는 배열
     */
    synchronized public void writeEntry(Collection entry) {
        for (Iterator line = entry.iterator(); line.hasNext(); )
            System.out.println(line.next());
        System.out.println();
    }

    /**
     * @brief 문자열을 출력하는 메서드
     * @details 문자열을 입력받아 문자열을 콘솔에 출력한다.
     * @param entry 출력하고 싶은 내용의 문자열
     */
    synchronized public void writeEntry(String entry) {
        System.out.println(entry);
        System.out.println();
    }
}
