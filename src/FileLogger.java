import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @editor Dongkuk Kim, dongkuk5411@nhnnext.org
 * @version 0.0.1
 * @brief 파일에 로그남기는 클래스
 * @details 파일에 로그를 직접 쓰는 로거 클래스이다.
 * @date 2014-01-16
 */
public class FileLogger implements Logger {

    PrintWriter out;

    /**
     * @param filename 파일이름
     * @throws IOException
     * @brief 파일로거의 생성자.
     * @details 로그파일을 생성한다.
     */
    public FileLogger(String filename) throws IOException {
        out = new PrintWriter(new FileWriter(filename), true);
    }

    /**
     * @param entry 출력하고 싶은 내용이 들어있는 배열
     * @brief 배열을 출력하는 메서드
     * @details 배열을 입력받아 배열에 있는 인자들을 파일에 출력한다.
     */
    synchronized public void writeEntry(Collection entry) {
        for (Iterator line = entry.iterator(); line.hasNext(); )
            out.println(line.next());
        out.println();
    }

    /**
     * @param entry 출력하고 싶은 내용의 문자열
     * @brief 문자열을 출력하는 메서드
     * @details 문자열을 입력받아 문자열을 파일에 출력한다.
     */
    synchronized public void writeEntry(String entry) {
        out.println(entry);
        out.println();
    }
}
