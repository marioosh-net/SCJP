/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4_operators;

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
 * ZASADY:  wyliczane sa od lewej do prawej (zawsze)
 *          *,/,% maja wyzszy priorytet niz + i - wiec sa pierwsze liczone
 */
class ArithmeticOperators {

  static public void main(String[] args) {
    new ArithmeticOperators();
  }

  ArithmeticOperators() {
    int x = 14 % 3;  // reszta z dzielenia = 2
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
    
  }
}
