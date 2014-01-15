import dispatcher.Dispatcher;
import logger.ConsoleLogger;
import logger.Logger;
import protocol.ProtocolFactory;

import java.net.ServerSocket;

public class ThreadMain {

  public static void main(String[] args) throws Exception {

    if (args.length != 3)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): [<Optional properties>]"
                                         + " <Port> <Protocol> <Dispatcher>");

    int servPort = Integer.parseInt(args[0]);  // Server Port 
    String protocolName = args[1];             // Protocol name
    String dispatcherName = args[2];           // Dispatcher name

    ServerSocket servSock = new ServerSocket(servPort);
    Logger logger = new ConsoleLogger();       // Log messages to console

    ProtocolFactory protoFactory = (ProtocolFactory)  // Get protocol factory
      Class.forName(protocolName + "protocol.ProtocolFactory").newInstance();

    Dispatcher dispatcher = (Dispatcher)       // Get dispatcher
      Class.forName(dispatcherName + "Dispatcher").newInstance();

    dispatcher.startDispatching(servSock, logger, protoFactory);
    /* NOT REACHED */
  }
}
