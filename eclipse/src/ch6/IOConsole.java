package ch6;

import java.io.Console;

/**
 * klasa java.io.Console
 */
public class IOConsole {

  public static void main(String[] args) {
    new IOConsole().doit();
  }

  void doit() {

    Console c = System.console();
    if (c != null) {
      System.out.print("podaj a: ");
      String input = c.readLine(); // z echo
      char b[] = c.readPassword(); // bez echo

      // remove password!
      for (int i = 0; i < b.length; i++) {
        b[i] = '\u0000';
      }
    }
  }
}

