package protocol;

import logger.Logger;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Michael J.Donahoo, Kenneth L.Calvert
 * @version 0.0.1
 * @brief HTTP 프로토콜을 생성하는 팩토리 클래스
 * @details 클라이언트의 요청을 처리할 HTTP 프로토콜 클래스를 생성한다.
 * @date 2014-01-16
 */
public class HTTPProtocolFactory implements ProtocolFactory {
    private static final int BUFSIZE = 32;          // Buffer size
    private static final String DOCROOTPROP = "DocumentRoot"; // Doc root property


    /**
     * @param clntSock 클라이언트 소켓
     * @param logger   로그 클래스
     * @return 쓰레드로 동작하는 객체
     * @brief HTTP 프로토콜 팩토리의 생성자
     * @details 클라이언트의 요청을 처리하는 Runnable 객체를 생성한다.
     */
    public Runnable createProtocol(final Socket clntSock, final Logger logger) {
        return new Runnable() {
            public void run() {
                String documentRoot = System.getProperty(DOCROOTPROP, "");
                HTTPProtocolFactory.handleClient(clntSock, logger, documentRoot);
            }
        };
    }

    /**
     * @param clntSock     클라이언트 소켓
     * @param logger       로그 클래스
     * @param documentRoot 문서 루트 위치
     * @brief 클라이언트의 요청을 다루는 메서드
     * @details 클라이언트가 요청한 파일을 전송하는 메서드이다
     */
    static private void handleClient(Socket clntSock, Logger logger,
                                     String documentRoot) {
        InputStream in = null;
        OutputStream out = null;
        ArrayList entry = new ArrayList();
        entry.add("Client address and port = " +
                clntSock.getInetAddress().getHostAddress() + ":" +
                clntSock.getPort());
        entry.add("Thread = " + Thread.currentThread().getName());
        try {
            in = clntSock.getInputStream();
            out = clntSock.getOutputStream();

            String filename = documentRoot + getFilename(in);
            entry.add("File = " + filename);
            FileInputStream fin = new FileInputStream(filename);
            String resp = "HTTP/1.0 200 OK\r\n\r\n";

            out.write(resp.getBytes("ISO-8859-1"));

            byte[] buf = new byte[BUFSIZE];
            int bytesRead;
            while ((bytesRead = fin.read(buf)) != -1)
                out.write(buf, 0, bytesRead);

            fin.close();
        } catch (Exception e) {
            String resp = "HTTP/1.0 404 File Not Found\r\n\r\nNot Found or Other I/O Error";
            entry.add("ERROR:  File not found");
            try {
                out.write(resp.getBytes("ISO-8859-1"));
            } catch (Exception dummy) {
            }
        }

        try {
            out.flush();
            clntSock.close();
        } catch (IOException e) {
            entry.add("Exception = " + e.getMessage());
        }

        logger.writeEntry(entry);
    }

    /**
     * @param in 입력 스트림
     * @return 클라이언트가 요청한 파일의 이름
     * @throws IOException
     * @brief 파일의 이름을 추출하는 메서드
     * @details 입력 스트림에서 클라이언트가 요청한 파일의 이름을 추출하는 메서드이다.
     */
    private static String getFilename(InputStream in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(in));
        tokenizer.ordinaryChar('/');
        tokenizer.wordChars('!', '~');
        tokenizer.nextToken();
        if ((tokenizer.ttype != tokenizer.TT_WORD) || (tokenizer.sval.compareTo("GET") != 0)) {
            throw new IOException("Unhandlable request");
        }

        if (tokenizer.nextToken() != tokenizer.TT_WORD) {
            throw new IOException("Unhandlable request");
        }

        return tokenizer.sval.substring(1);
    }
}
