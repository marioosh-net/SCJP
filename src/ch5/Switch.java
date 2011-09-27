/*
 * FlowControl_Exception_Assertion
 */
package ch5;

/**
 *
 * ZASADY:
 *  - expression must be: a char, byte, short, int, or, as of Java 6, an enum.
 *  - case constant: compile time constant!! (podczas kompilacji musi byc znana jej wartosc)
 *
 *  break: bez jego uzycia po spelnieniu warunku z case wykonane
 *        zostana wszystkie bloki case (lacznie z default) do konca!!!!
 *        break jest SUPERwazny.
 *  default: dziala jak normlany case, ale wejscie nastepuje bezwarunkowo!!!
 */
public class Switch {

  static public void main(String[] args) {
    new Switch();
  }

  Switch() {
    int expression = 2;

    switch(30) {
    case 2: System.out.println("OWOWO");
    }
    switch (expression) {
      case 1:
        System.out.println("1");
        break;
      case 2:
        System.out.println("2");
        break;
      default:
        System.out.println("default");
    }

    /**
     * mozna zrobic rzutowanie
     */
    double d = 1;
    switch ((int) d) {
      case 1:
        System.out.println("1");
        break;
      default:
        System.out.println("default");
    }

    /**
     * dozwolony boxing
     */
    switch (new Integer(4)) {
      case 1:
      case 2:
      default:
    }

    /**
     * w case tylko stale lub zmienne finalne z przypisana wartoscia
     */
    final int a = 1;
    final int b;
    b = 2;
    int x = 0;
    switch (x) {
      case a: // ok
      case b: // compiler error
    }

    /**
     * pulapka 1
     */
    byte g = 2;
    switch (g) {
      case 23:
      case 128: // 128 nie miesci sie w char
    }

    /**
     * pulapka 2
     * nie mozna zrobic dwoch przypadkow na ta sama wartosc wyrazenia
     */
    int temp = 90;
    switch (temp) {
      case 80:
        System.out.println("80");
      case 80:
        System.out.println("80"); // won't compile!
    }

    /**
     * default:
     *  ZASADA: dziala jak normlany case, ale spelnia kazdy warunek!!
     */
    switch (new Integer(0)) {
      case 1:
        System.out.println("Case 1");
      default:
        System.out.println("Default");
      case 2:
        System.out.println("Case 2");
    }
    /**
     *  Output:
     * Default
     * Case 2
     */


  }
}
