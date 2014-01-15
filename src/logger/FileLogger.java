package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FileLogger implements Logger {

  PrintWriter out;  // Log file

  public FileLogger(String filename) throws IOException {
    out = new PrintWriter(new FileWriter(filename), true);  // Create log file
  }

  synchronized public void writeEntry(Collection entry) {
    for (Iterator line = entry.iterator(); line.hasNext();)
      out.println(line.next());
    out.println();
  }

  synchronized public void writeEntry(String entry) {
    out.println(entry);
    out.println();
  }
}
