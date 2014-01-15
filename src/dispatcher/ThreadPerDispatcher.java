package dispatcher;

import logger.Logger;
import protocol.ProtocolFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPerDispatcher implements Dispatcher {

  public void startDispatching(ServerSocket servSock, Logger logger,
                               ProtocolFactory protoFactory) {
    // Run forever, accepting and spawning threads to service each connection
    for (;;) {
      try {
        Socket clntSock = servSock.accept();  // Block waiting for connection
        Runnable protocol = protoFactory.createProtocol(clntSock, logger);
        Thread thread = new Thread(protocol);
        thread.start();
        logger.writeEntry("Created and started Thread = " + thread.getName());
      } catch (IOException e) {
	logger.writeEntry("Exception = " + e.getMessage());
      }
    }
    /* NOT REACHED */
  }
}
