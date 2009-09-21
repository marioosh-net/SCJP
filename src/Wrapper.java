/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Klasy otaczające (Wrappers)
 *
 * To co trzeba zapamietac na egzamin:
 * In summary, the essential method signatures for Wrapper conversion methods are
 *   primitive xxxValue() - to convert a Wrapper to a primitive
 *   primitive parseXxx(String) - to convert a String to a primitive
 *   Wrapper valueOf(String) - to convert a String to a Wrapper
 */
public class Wrapper {

  { // sedno
    Integer a = new Integer("10");
    Integer a2 = Integer.valueOf("10");
    int a3 = Integer.parseInt("10");
    int a4 = a.intValue();
  }
  // standardowo po dwa kontruktory (wyjatek to Character)
  Integer i = new Integer(1);
  Integer j = new Integer("10");
  Character ch = new Character('a');

  // standarowo 2 metody statyczne valueOf (ale nie zawsze)
  Float f2 = Float.valueOf("3.14f");
  Integer i2 = Integer.valueOf("1012", 3); // drugi parametr to radix - system liczbowy (dwojkowy, 8-kowy itd.)
  Integer i3 = Integer.valueOf("1011", 2); // tutaj dwojkowy
  Integer i4 = Integer.valueOf("ff", 16); // tutaj hexadecymalny

  // standardow metody konwertujace xxxValue()
  Integer k = new Integer(42);
  byte b = k.byteValue();
  short s = k.shortValue();
  double d = k.doubleValue();
  // parseXxx() i valueOf()
  Integer G = Integer.valueOf("10");  // zwraca obiekt
  int g = Integer.parseInt("10");     // zwraca typ prymitywny

  // metoda toString()
  java.lang.Double xd = new java.lang.Double("3.14");


  {
    System.out.println("xd = " + xd.toString());
  } // result is xd = 3.14

  static public void main(String[] args) {
    System.out.println(new Wrapper().j);


    Boolean b = new Boolean("true");
    if (b) { // won't compile, using Java 1.4 or earlier
      System.out.println(new Wrapper().i2);
      System.out.println(new Wrapper().i4);
    }
  }
}

/**
 *
 *
 * Autoboxing - kompilator zamyka wg potrzeb typy prymitiwne w obiekcie otaczającym, np. int -> Integer
 * Unboxing - proces odwrotny: Integer -> int
 */
class Boxing {

  static public void main(String[] args) {
    new Boxing();
  }

  Boxing() {
    // auto-unboxing
    Integer i = new Integer("10");
    i++;  // kompilator robi unboxing
    System.out.println(i.intValue());


    // auto-boxing
    Integer j = new Integer("10");
    Integer k = j;
    System.out.println(k == j);

    // tutaj w gruncie rzeczy robiony jest nowy obiekt i przypisywany do rerefencji k
    /* k2 = k.intValue();
     * k2++;
     * k = new Integer(k2); */
    k++;

    System.out.println(k + "," + j);
    System.out.println(k == j); // k jest rozne od j


    // equals(), ==, !=
    // UWAGA!!!!
    Integer i1 = 1000;
    Integer i2 = 1000;
    if (i1 != i2) {
      System.out.println("different objects");
    }
    if (i1.equals(i2)) { // porownuje zawartosc obiektow
      System.out.println("meaningfully equal");
    }
    // a tutaj....
    Integer j1 = 10;
    Integer j2 = 10;
    // w tym wypadku okazuje sie ze j1 i j2 to TE SAME OBIEKTY
    // dla pewnych typow klas otaczajacych lub zakresow tych typow java stosuje polityke:
    // ze jesli wartosci prymitwne sa rowne, to obiekty tez sa rowne (==) !!!!
    //
    // ta regula dotyczy:
    /**
     *  ■ Boolean
     *  ■ Byte
     *  ■ Character from \u0000 to \u007f (7f is 127 in decimal)
     *  ■ Short and Integer from -128 to 127
     */
    if (j1 == j2) {
      System.out.println("same objects");
    }
  }
}

/**
 *
 *
 *
 * uwaga na NullPointerException
 */
class Boxing2 {

  static Integer x;

  public static void main(String[] args) {
    doStuff(x); // NullPointerException, because can't unboxing null'a
    doStuff2(x); // tak ok, bo nie ma unboxingu
  }

  static void doStuff(int z) {
  }

  static void doStuff2(Integer z) {
  }
}

