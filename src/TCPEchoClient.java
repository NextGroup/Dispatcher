import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream

/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @editor Dongkuk Kim, dongkuk5411@nhnnext.org
 * @version 0.0.1
 * @brief 서버에 요청을 보내는 클라이언트 클래스
 * @details 서버에 에코 프로토콜로 요청을 보낸다.
 * @date 2014-01-16
 */
public class TCPEchoClient {

    /**
     * @param args 서버주소, 보낸 단어, 포트번호가 들어있는 콘솔 입력 배열
     * @throws IOException
     * @brief 서버에 요청을 보내는 메인 메서드
     * @details 콘솔에서 입력받은 서버와 단어를 에코 프로토콜로 전송한다.
     */
    public static void main(String[] args) throws IOException {

        if ((args.length < 2) || (args.length > 3))
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

        String server = args[0];
        byte[] byteBuffer = args[1].getBytes();

        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

        Socket socket = new Socket(server, servPort);
        System.out.println("Connected to server...sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(byteBuffer);

        int totalBytesRcvd = 0;
        int bytesRcvd;
        while (totalBytesRcvd < byteBuffer.length) {
            if ((bytesRcvd = in.read(byteBuffer, totalBytesRcvd,
                    byteBuffer.length - totalBytesRcvd)) == -1)
                throw new SocketException("Connection close prematurely");
            totalBytesRcvd += bytesRcvd;
        }

        System.out.println("Received: " + new String(byteBuffer));

        socket.close();
    }
}
