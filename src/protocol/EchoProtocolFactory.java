package protocol;

import logger.Logger;

import java.net.Socket;

public class EchoProtocolFactory implements ProtocolFactory {
  public Runnable createProtocol(Socket clntSock, Logger logger) {
    return new EchoProtocol(clntSock, logger);
  }
}
