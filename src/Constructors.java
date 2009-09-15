/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * konstructory
 *
 * konstruktory automatycznie sa publiczne
 */
public class Constructors {

  Constructors() {
    System.out.println("Constructors constructor 1");
  }

  public Constructors(int x) {
    System.out.println("Constructors constructor 2");
  }

  private Constructors(char a) {
    System.out.println("Constructors constructor too 1");
  }

  protected Constructors(String str) {
    System.out.println("Constructors constructor too 2");
  }

  // legal but stupid
  void Constructors() {
    System.out.println("Not constructor!!!");
  }

  public static void main(String[] args) {
    new Constructors();
    new Constructors(1);
    new Constructors('a');
    new Constructors("ala");

    new Constructors_sub();

    // prywatny kontruktor nie jest dostepny!!
    new Constructors_sub(1); // error

  }
}

class Constructors_sub extends Constructors {

  Constructors_sub() {
    super(); // niejawnie konstruktor klasy bazowej jest wolany, nawet jesli nie uzyjemy super();
    System.out.println("Constructors_sub constructor 1");
  }

  private Constructors_sub(int x) {
    super(1); // można natomiast użyć jawnie przeciążonego kontruktora klasy bazowej
    System.out.println("Constructors_sub constructor 2");
  }
}

class Outside {

  Outside() {
    // prywatny konstrukctor nie jest dostepny poza klasa
    new Constructors_sub(1);
  }
}

/**
 *
 *
 * redefinicja konstruktora domyslnego
 */
class Outsider {

  // przesloniecie konstruktora automatycznego (generowanego przez kompilator)
  protected Outsider() {
    System.out.println("Outsider 1");
  }

  public static void main(String[] a) {
    new Outsider();
  }
}

/**
 *
 *
 * sytuacja kiedy brak konstruktora automatycznego (bezparametrowego)
 *
 * kiedy zdefiniujemy w klasie jakikolwiek konstruktor, kompilator nie
 * wygeneruje dla nas automatycznego konstruktora !!!! automatyczny konstruktor jest
 * tylko wtedy kiedy nie zdefiniujemy ZADNEGO konstruktora
 */
class Woman {

  public static void main(String[] a) {
    new Woman(1); // ok
    new Woman(); // error (nie ma konstruktora automatycznego
  }

  Woman(int i) {
    super(); // invoking java.lang.Object contructor
    System.out.println("Woman creator");
  }
}
