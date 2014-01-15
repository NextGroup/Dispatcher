package logger;

import java.util.Collection;
import java.util.Iterator;

public class ConsoleLogger implements Logger {
  synchronized public void writeEntry(Collection entry) {
    for (Iterator line = entry.iterator(); line.hasNext();)
      System.out.println(line.next());
    System.out.println();
  }

  synchronized public void writeEntry(String entry) {
    System.out.println(entry);
    System.out.println();
  }
}
