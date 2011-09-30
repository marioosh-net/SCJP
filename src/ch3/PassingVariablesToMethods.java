package ch3;
import ch2.Test;


/**
 *
 * PODSTAWOWA ZASADA:
 * It makes no difference if you're passing primitive or reference variables, you are
 * always passing a copy of the bits in the variable.
 *
 * przekazwana jest kopia, ale jak kopia jest referencja, to mozemy przez nia zmienic wnetrze obiektu,
 * natomiast jak jest wartoscia, to nie zmienimy oryginalnej zmiennej !!!!
 *
 * prymitiwne sa przekazywane zawsze przez wartosc
 * 
 * UWAGA: tablica jest obiektem, wiec przekazywanie jej to przekazywanie referencji
 * wiec: 
 *          int[]a = {1};
 *          test(a);  // zmieni wartosc w tablicy
 * 			test(int[] a) { a[0] = 2; }  
 */
public class PassingVariablesToMethods {

  static public void main(String[] args) {
    new Test();
  }
}

class Book {

  int id;

  Book(int id) {
    this.id = id;
  }
}

class Test {

  Test() {
    Book ksiazka = new Book(10);
    doIt(ksiazka);
    System.out.println(ksiazka.id);

    int test = 10;
    makeIt(test);
    System.out.println(test);
  }

  void doIt(Book book) {
    book.id = 20;
    book = null; // to nie robi b = null, bo book to kopia referencji ksiazka
    book = new Book(2); // tutaj kopia referencji wskaze na nowy obiekt, ale oryginal bedzie wskazywal na to samo!
  }

  void makeIt(int i) {
    // nie zmienimy oryginalnej wartosci zmiennej test, bo i to kopia
    i = 0;
  }
}

/**
 *
 *
 *
 * Shadowing
 * kiedy przykryjemy zmienna instancyjna zmienna lokalna, to uzywajac jej nazwy
 * zawsze bedzie ona odnosic sie do zmiennej lokalnej
 */

// primitives
class Foo1 {

  static int size = 7;

  static void changeIt(int size) {
    size = size + 200;  // dziala na lokalnej zmiennej size przakazywanej w metodzie changeIt()
    System.out.println("size in changeIt is " + size);
  }

  public static void main(String[] args) {
    Foo1 f = new Foo1();
    System.out.println("size = " + size);
    changeIt(size);
    System.out.println("size after changeIt is " + size);
  }
}

// objects
class Bar {

  int barNum = 28;
}

class Foo {

  Bar myBar = new Bar();

  void changeIt(Bar myBar) {
    myBar.barNum = 99;  // tutaj normlanie odnosimy sie do membra, bo jest ta sama referencja
    System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
    myBar = new Bar();  // tutaj juz nastepuje przypisanie nowego obiektu do referencji i dalsze zmiany
                        // leca na nowym lokalnym obiekcie
    myBar.barNum = 420;
    System.out.println("myBar.barNum in changeIt is now " + myBar.barNum);
  }

  public static void main(String[] args) {
    Foo f = new Foo();
    System.out.println("f.myBar.barNum is " + f.myBar.barNum);
    f.changeIt(f.myBar);
    System.out.println("f.myBar.barNum after changeIt is " + f.myBar.barNum);
  }
}

