import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * @brief 간단한 서버를 구현한 클래스이다.
 * @details 요청을 분석하여 적절한 메서드에 전달한다.
 * @author Dongkuk Kim, dongkuk5411@nhnnext.org
 * @date 2013-01-15
 * @version 0.0.1
 */
public class ServerInitializer {

    /**
     * @brief 메인 메서드이다.
     * @details ServerInitialize 클래스를 초기화하고 run 메서드를 실행한다.
     * @param args 콘솔 파라미터이다. 아무것도 없다.
     * @exception IOException
     */
    public static void main(String[] args) {
        try {
            new ServerInitializer().run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @brief 사용자의 요청을 받는 메서드이다.
     * @details 사용자의 요청을 받아 header와 body로 나눈다. 무한 반복되어 사용자의 요청을 계속 처리한다.
     * @throws IOException
     */
    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);

        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            byte[] buffer = new byte[6];
            inputStream.read(buffer);
            String header = new String(buffer);

            buffer = new byte[1024];
            inputStream.read(buffer);
            String data = new String(buffer);

            dispatch(header, data);
        }
    }

    /**
     * @brief 데이터를 적절한 메서드에 전달한다.
     * @details 데이터의 header에 따라 data를 처리할 적절한 메서드를 찾아 전달한다.
     * @param header 데이터의 헤더
     * @param data 데이터의 바디
     */
    private void dispatch(String header, String data) {
        String[] params = new String[10];
        StringTokenizer token = new StringTokenizer(data, "|");
        int i = 0;

        while (token.hasMoreTokens())
            params[i++] = token.nextToken();

        switch (Integer.valueOf(header.split("x")[1], 16)) {
            case 0x5001:
                sayHello(params);
                break;
            case 0x6001:
                updateProfile(params);
                break;
        }
    }

    /**
     * @brief 파라미터에서 데이터를 뽑아 출력한다.
     * @details 파라미터에서 이름과 나이를 뽑아 출력한다.
     * @param params 이름과 나이가 순서대로 들어있는 배열
     */
    private void sayHello(String[] params) {
        System.out.println("SayHello -> name : " + params[0] + " age : " + params[1]);
    }

    /**
     * @brief 파라미터에서 데이터를 뽑아 출력한다.
     * @details 파라미터에서 아이디, 비밀번호, 이름, 나이, 성별을 뽑아 출력한다.
     * @param params 아이디, 비밀번호, 이름, 나이, 성별이 순서대로 들어있는 배열
     */
    private void updateProfile(String[] params) {
        System.out.println("UpdateProfile -> " +
                " id :" + params[0] +
                " password : " + params[1] +
                " name : " + params[2] +
                " age : " + params[3] +
                " gender: " + params[4]);
    }
}
