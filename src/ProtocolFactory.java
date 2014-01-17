import java.net.Socket;

public interface ProtocolFactory {
  public Runnable createProtocol(Socket clntSock, Logger logger);
}
