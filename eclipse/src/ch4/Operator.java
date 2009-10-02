/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4;

/**
 *
 * @author muniek
 */
public class Operator {

  static public void main(String[] args) {
    int x = 0;

    // compound operators
    x *= 2 + 5;       // to samo. zawsze to co po prawej od znaku '=' jest wyliczane jako pierwsze
    x = x * (2 + 5);  // dopiero pozniej dziala 'compound' operator

    // relational operators
    boolean b = 100 > 99;
    Boolean B = 100 > 99;

    // mozna porownywac chary (nie polecane)
    char sex = 'm';
    if (sex <= 'f') {
      System.out.println("this is a woman");
    }
    // mozna porownywac char'a z liczbą (intem) - java uzywa wartosci Unicode dla char'a
    if (sex <= 22) {
    }

    /** sprawdzanie "równości" / "nierówności"
     * ZASADA: ==,!= porownuje:
     *  characters
     *  numbers
     *  booleans
     *  Object references
     * 
     */
    if (b == 20 || b == 'c') { // incomparable types (boolean to int)
    }

    /*
     *
     * Porownywanie prymitywow
     */
    System.out.println("char 'a' == 'a'? " + ('a' == 'a'));
    System.out.println("char 'a' == 'b'? " + ('a' == 'b'));
    System.out.println("5 != 6? " + (5 != 6));
    System.out.println("5.0 == 5L? " + (5.0 == 5L));
    System.out.println("true == false? " + (true == false));

    /**
     * Pulapka 1
     */
    if (x = 1) {  // niekompatybilne typy. wymagany boolean, a jest int
    }

    /**
     * UWAGA: ale...
     */
    boolean bool = false;
    if (bool = true) { // takie cos TYLKO na boolean'ach i Boolean'ach!!!!
      // wykona sie bo zostanie przypisane bool = true i to w efekcie daje true!
    }
  }
}

interface Readable {
}

class Book implements Readable {

  int i;

  Book(int i) {
    this.i = i;
  }
}

class NovelBook extends Book {

  NovelBook(int i) {
    super(i);
  }

  public void readNovel() {
    System.out.println("reading novel...");
  }
}

class ObjectsCompare {

  static public void main(String[] args) {
    new ObjectsCompare();
  }

  ObjectsCompare() {
    Book b0 = new Book(1);
    Book b1 = new Book(1);
    Book b2 = b1;
    // porownuje sie referencje
    if (b1 == b2) {
      System.out.println("the same object");
    }
    // porowuje "zawartosc" obiektow
    if (b0.equals(b2)) {
      System.out.println("the same contents");
    }

    /**
     * instanceof operator
     * sprawdzanie czy X jest typu Y
     */
    String s = "sss";
    if (s instanceof String) {
      System.out.println("s is String");
    }
    if (s instanceof Object) {  // ALWAYS true
      System.out.println("s is Object");
    }

  }
}

class OperatorInstanceOf {

  static public void main(String[] args) {
    new OperatorInstanceOf();
  }

  OperatorInstanceOf() {
    /**
     * intanceof Interfejs
     * daje true dla wszystkich klas implementujacych interfejs (nawet niejawnie przy dziedziczeniu)
     */
    Book b0 = new Book(1);
    if (b0 instanceof Readable) { // interfejs to tez typ
      System.out.println("b0 is Readable");
    }
    // wykorzystanie do bezpiecznego downcasting'u
    Book book = new NovelBook(1);
    if (book instanceof NovelBook) {
      ((NovelBook) book).readNovel();
    }
    /**
     * Pulapka z null!!!
     */
    String a = null;
    boolean b = null instanceof String; // -> ALWAYS false
    boolean c = a instanceof String;    // -> false
    System.out.println(b + " " + c);
  }
}

/**
 *
 * pulapka z instanceof
 */
class Animal {
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class Test {

  static public void main(String[] args) {
    Dog d = new Dog();
    if (d instanceof Cat) { // niekonwertowalne typy
      System.out.println("cat");
    }
    if (d instanceof Animal) {  // tutaj juz ok
      System.out.println("animal");
    }
  }
}

/**
 *
 * pulapka z instanceof i tablicami
 * ZASADA: tablica to obiekt, wiec jest instaceof Object! Kazda talica !
 */
class ArrayTest {

  ArrayTest() {
    int[] nums = new int[3];
    if (nums instanceof Object) { // ok -
    } // result is true
  }
}

/**
 *
 *
 * ZASADY:  wyliczane sa od lewej do prawej (ZAWSZE, nawet przy konktatenacji)
 *          *,/,% maja wyzszy priorytet niz + i - wiec sa pierwsze liczone
 */
class ArithmeticOperators {

  static public void main(String[] args) {
    new ArithmeticOperators();
  }

  ArithmeticOperators() {
    int r = 14 % 3;  // reszta z dzielenia = 2
    System.out.println(x);

    /**
     * Konkatenacja stringow
     *
     * ZASADA:
     * If either [jakikolwiek] operand is a String, the + operator becomes a String concatenation
     * operator. If both operands are numbers, the + operator is the addition operator.
     */
    String a = "String";
    int b = 3;
    int c = 7;
    System.out.println(a + b + c);    // -> String37
    // pierwsza operacja w nawiasach, w wyniku czego dostajemy stringa + liczbe -> wynik string
    System.out.println(a + (b + c));  // -> String10
    System.out.println(a + b - c);    // Compilation fails
    System.out.println(a + (b - c));  //

    System.out.println("" + b + 3);   // -> 33
    System.out.println(b + 3);        // -> 6
    System.out.println(2 + (a + a));  // -> 2StringString

    /**
     * Icrement / Decrement operators
     */
    int j = 0;
    System.out.println(j++);  // -> 0; dodanie nastepuje dopiero PO wyswietleniu (uzyciu j w wyrazeniu)
    System.out.println(j);    // -> 1;
    System.out.println(++j);  // -> 2; dodanie nastepuje PRZED wyswietleniem (uzyciem j w wyrazeniu)
    System.out.println(j);    // -> 2;

    int x = 2;
    int y = 3;
    if ((y == x++) || (x < ++y)) {
      // If 3 is equal to 2 OR 3 < 4
      System.out.println("x = " + x + " y = " + y);
    }

    /**
     * UWAGA
     * fajny przyklad!!
     */
    int index = 1;
    int[][] dd = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1, 0}};
    System.out.println(dd[index++][index++]); //dd[1][2];

    /**
     * pulapka
     */
    int result = 1;
    result = (true) ? result-- : result++; // result bedzie = 1
    // dlatego bo wczesniej wartosc zostanie przypisana, a pozniej odjeta!


  }
}

/**
 *
 * Conditional operators
 */
class Conditional {

  static public void main(String[] args) {
    new Conditional();
  }

  Conditional() {
    boolean b = true;
    int j = b ? 5 : 2; // jesli b == true to j = 5 else j = 2
    j = j > 2 ? 1 : 3;

    // zagniezdzone
    String test = true ? "test" : j > 2 ? ">2" : "<=2";

  }
}

/**
 *
 * Logical Operators
 */
class Logical {

  /**
   *
   * Bitwise operators
   * porownuja bit po bicie
   *  & - oba bity musza byc ustawione, wtedy ustawiana jest 1
   *  | - jeden lub drugi bit ustaiony, wtedy ustawiana jest 1
   *  ^ - tylko jeden ustawiony
   */
  class Bitwise {

    Bitwise() {
      byte b1 = 6 & 8;  // -> 0110 & 1000 = 0000
      byte b2 = 7 | 9;  // -> 0111 | 1001 = 1111
      byte b3 = 5 ^ 4;  // -> 0101 ^ 0100 = 0001
    }
  }

  /**
   * || i &&  - short-circuit
   *            (sprawdzaja tylko do momentu kiedy warunek bedzie spelniony/niespelniony)
   * | i &    - non-short-circuit
   *            (sprawdzaja WSZYSTKIE skladowe od lewej do prawej)
   * ^        - non-short-circuit
   *            exclusive-OR (XOR) - tylko jeden operand moze byc true
   * !        - zmienia warunek na przeciwny (wiadoma zasada)
   * ZASADA: dzialaja tylko na boolean'ach!!!!
   */
  Logical() {
    int a = 2;
    int b = 5;
    if (a > b && b == 1) {
      // sprawdza od lewej do prawej. jesli lewy nie jest spelniony, to nie sprawdza
      // juz nastepnych!! dlatego jest szybki (short-circuit)
    }
    if (a > b || b == 1) {
      // tutaj jesli piewszy jest na true, to nie sprawdza kolejnych
    }
    if (func(2) || func(3)) {
      // func() wywola sie tylko raz
    }
    if (func(2) | func(3)) {
      // func() wywola sie 2 razy !
    }

    // xor
    System.out.println("xor " + ((2 < 3) ^ (4 > 3))); // -> false

    if (5 && 6) {
    } // compilation error (tylko booleans)

  }

  boolean func(int i) {
    System.out.println("func");
    return i > 0 ? true : false;
  }
}

