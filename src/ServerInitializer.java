import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Created by dongkuk on 1/7/14.
 */
public class ServerInitializer {
    public static void main(String[] args) {
        try {
            new ServerInitializer().run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

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

    private void sayHello(String[] params) {
        System.out.println("SayHello -> name : " + params[0] + " age : " + params[1]);
    }

    private void updateProfile(String[] params) {
        System.out.println("UpdateProfile -> " +
                " id :" + params[0] +
                " password : " + params[1] +
                " name : " + params[2] +
                " age : " + params[3] +
                " gender: " + params[4]);
    }
}
