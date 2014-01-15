package dispatcher;

import logger.Logger;
import protocol.ProtocolFactory;

import java.net.ServerSocket;

public interface Dispatcher {
  public void startDispatching(ServerSocket servSock, Logger logger,
                               ProtocolFactory protoFactory);
}
