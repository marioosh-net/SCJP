/*
 * FlowControl_Exception_Assertion
 */
package ch5;

/**
 *
 * @author muniek
 */
public class Loops {

  static public void main(String[] args) {
    new Loops();
  }

  Loops() {
    boolean a = false;
    int i = 10;

    /**
     * while - moze sie w ogole nie wykonac
     */
    while (i > 0) {
      System.out.println("while:" + i--);
    }

    /**
     * do,while - wykona sie przynajmniej raz!
     */
    i = 1;
    do {
      System.out.println("do:" + i++);
    } while (i < 10);


    /**
     * petla for
     *
     * for(init; test; expression)
     *  test - only one!!; sprawdzany przed kazda iteracja
     *  expressions - 0 or more, wyliczane po kazdej iteracji
     */
    for (int j = 1, k = 0; j < 10; j++, k++) {
      // mozliwosci wyjscia z petli:
      // return; - wychodzi z petli i z metody;
      // break; - wychodzi z petli;
      // System.exit(_);
      // exception
    }
    // k jest widoczne tylko w petrli for bo jest w niej zadeklarowane
    //System.out.println(k);  // compilation error; 

    /**
     * for jak while
     */
    for (; i < 10;) { // dzala jak while(i < 10)
    }

    /**
     * petla for, rozne takie...
     */
    int k = 0;
    Integer l = 0;
    char h = 's';
    Object o = null;
    for (k = 0, l = 2, h = 'a', o = null;; h = 'b') {
      break;
    }

    int zz = 1;
    String x;
    for (x = "", zz = 0 ;;) {

    }

    // expression: moze byc nawet takie
    int m = 3;
    for (int n = 1; m != 1; System.out.println("ala"), System.out.println("ma kota")) {
      m = m - n;
    }

    /**
     * uzycie contiune
     */
    for (int z = 0; z < 10; z++) {
      if (z == 5) {
        System.out.println("continue");
        continue; // przejdz do nastepnej iteracji
      } else {
        System.out.println("z " + z);
      }
    }

    /**
     * for nieskonczony
     */
    for (;;) {
      System.out.println("Inside an endless loop");
      break; // bez tego petla nieskonczona
    }
    int z = 0;  // ureachable !!! (bo jest petla nieskonczona)

  }
}

/**
 * petla for dla kolekcji, tablic itp (od Javy 6)
 *  for( deklaracja elementu: tablica/kolekcja/funkcja zwracajaca tablice/kolekcje) { ... }
 *
 *  deklarowany element musi byc kompatybilny z elementami kolekcji
 */
class EnhancedFor {

  static public void main(String[] args) {
    new EnhancedFor();
  }

  EnhancedFor() {
    int x = 1;
    int collection[] = {1, 2, 3, 4, 5};

    for (Integer element : collection) {
      System.out.println(element);
    }
    for (Integer element : getArr()) {
      System.out.println(element);
    }
    for (Object element : new char[]{'a', 'b'}) {
      System.out.println(element);
    }

  }

  int[] getArr() {
    return new int[]{3, 2, 1};
  }
}

/**
 * Labeled loops / statements
 *
 * wykorzystywane przy break i continue do wskazania
 *    ktora petla ma sie zakonczyc, lub skoczyc do nastepnej iteracji
 */
class Labeled {

  static public void main(String[] args) {
    new Labeled();
  }

  Labeled() {
    int y = 10;

    outer:  // label
    for (int x = 3; x < 20; x++) {
      while (y > 7) {
        y--;
        if (y == 8) {
          break outer;  // labelled break
        }
      }
    }
  }
}
