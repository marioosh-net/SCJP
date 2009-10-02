package ch6;

import java.io.*;

/**
 *
 */
public class FileIO {

  public static void main(String[] args) {
    //new FileIO().create();
    //new FileIO().write();
    //new FileIO().read();
    new FileIO().printerWriter();
    new FileIO().betterRead();

    //new FileIO().createDir();
    new FileIO().rename();
    new FileIO().delete();
    new FileIO().list();
  }

  /**
   * Simple create
   */
  void simpleCreate() {
    File file = new File("test2.txt");
    System.out.println(file.exists());  // czy plik/katalog istnieje ?

    try {
      boolean b = file.createNewFile(); // utworz nowy plik, ale tylko jesli on nie istnieje!
      System.out.println(file.exists());

      if (b) {
        System.out.println("file created");
      } else {
        System.out.println("file exist");
      }

    } catch (IOException e) {
    }
  }

  /**
   * create by Writer / Stream
   */
  void create() {
    File file = new File("foo"); // no file yet
    try {
      PrintWriter pw = new PrintWriter(file);
      pw.close();
    } catch (Exception e) {
    }
  }

  /**
   * Standard write by FileWriter
   */
  void write() {
    File f = new File("file.txt");
    try {
      FileWriter fw = new FileWriter(f);  // tworzy plik
      fw.write("tekscik");
      fw.flush(); // dla pewnosci ze wszystko poszlo do pliku (z bufora)
      fw.close(); // free up resources

    } catch (IOException e) {
    }
  }

  /**
   * Standard read by FileReader
   */
  void read() {
    File f = new File("file.txt");
    try {
      FileReader fr = new FileReader(f);
      char[] b = new char[2];

      // czyta maksymalnie tyle bajtow jaki jest rozmiar b
      // i zwraca ilosc przeczytanych znakow (-1 jesli osiagnie koniec pliku)
      int x = 0;
      while (fr.read(b) != -1) {
        System.out.print(b);
      }
      System.out.println(x);
      fr.close(); // free up resources

    } catch (IOException e) {
    }
  }

  void betterRead() {
    File f = new File("file.txt");
    try {
      FileReader fr = new FileReader(f);
      BufferedReader br = new BufferedReader(fr);
      String s;
      while ((s = br.readLine()) != null) {
        System.out.println(s);
      }
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void printerWriter() {
    File f = new File("file.txt");
    try {
      FileWriter fw = new FileWriter(f);
      PrintWriter pw = new PrintWriter(fw);

      pw.println("Ala ma kota");
      pw.println("A kot ma ale");
      pw.flush();
      pw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * create directory
   */
  void createDir() {
    File d = new File("dir");
    d.mkdir();  // utworzenie katalogu
    System.out.println(d.exists());

    // utworzenie pliku w danym katalogu
    File f = new File(d, "file.txt");
    try {
      f.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    /**
     * uwaga na probe utworzenie pliku w nie istniejacym (nie utworzonym) katalogu
     */
    File d1 = new File("dir2");
    File f1 = new File(d1, "file.txt");
    try {
      f1.createNewFile(); // exception -> nie bylo d1.mkdir()!
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * renameTo(), delete()
   */
  void rename() {
    File f = new File("file.txt");
    File f2 = new File("file4.txt");
    System.out.println(f.renameTo(f2) ? "file renamed to " + f2.getName() : "not renamed");
  }

  void delete() {
    File f = new File("file.txt");
    System.out.println(f.delete() ? "deleted" : "not deleted");
    
    System.out.println(new File("file4.txt").delete() ? "4 deleted" : "4 not deleted");
  }

  /**
   * listing / searching
   */

  void list() {
    File dir = new File(".");
    // list() - zwraca talice z zawartoscia katalogu
    for(String s: dir.list()) {
      System.out.println(s+",");
    }

    // proba wylistowania pliku, to NullPointerException
    for(String s: new File("file.txt").list()) {
      System.out.println(s+",");
    }
    
  }
}

