/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * ZASADA:  1. membry (zmienne instancyjne) niezainicjowane jawnie przyjmuja wartosci domyslne
 *          2. zmienne lokalne instant zdefiniowane w metodach musza byc inicjowane (tablice tez) !!!!
 *              uzycie niezainicjowanej zmiennej lokalnej = blad kompilatora
 *
 */
public class Initialization {

  // primitives
  int i;        //default 0
  char b;       //default '\u0000'
  boolean k;    //default false

  // object references (zawsze default NULL)
  String str;   //default null
  java.util.Date date;  // null

  static public void main(String[] a) {
    Initialization init = new Initialization();

    System.out.println(init.i);
    System.out.println(init.b);
    System.out.println(init.k);
    System.out.println(init.str);
    System.out.println(init.date);

    // UWAGA!!! // java null pointer exception !
    // BO str nie wskazuje na zaden obiekt
    try {
      init.str.toLowerCase();
    } catch (Exception e) {
      e.printStackTrace();
    }

    init.str = "ALA MA KOTA";
    System.out.println(init.str.toLowerCase());     // teraz ok :)
  }

  void setStr(String str) {
    this.str = str;
  }
}

/**
 *
 *
 *
 * Arrays
 * 
 *  ZASADA:
 *  elementy tablicy ZAWSZE sa domyslnie inicjowane takimi wartosciami,
 *  jakimi bylyby inicjowane odpowiednie typy zmiennych instancyjnych
 *
 *  lokalne tablice:      elementy sa inicjowane, ale sam obiekt tablicy NIE !!
 *  instancyjne tablice:  obiekt tablcy = null, wiec jest nie do uzycia
 */
class Arrays {

  int[] instant1;               // obiekt null
  int[] instant = new int[10];  // obiekt nie null, elementy zainicjowane

  void doit() {
    int[] local;
    System.out.println(local); // blad kompilatora (proba uzycia niezainicjowanej zmiennej)
  }

  public static void main(String[] args) {
    Arrays arrays = new Arrays();
    System.out.println("obiekt instant: " + arrays.instant);
    System.out.println("obiekt instant1: " + arrays.instant1);

    for (int j = 0; j < arrays.instant.length; j++) {
      System.out.println(arrays.instant[j] + ",");
    }

    // tak juz nie ok, bo instan1 = null
    for (int j = 0; j < arrays.instant1.length; j++) {  // runtime error (null pointer exception)
      System.out.println(arrays.instant1[j] + ",");
    }
  }
}

/**
 *
 *
 *
 * zmienne lokalne (w ciele metod)
 *    nie sa nigdy inicjowane automatycznie !!! ("nie maja wartosci")
 *    UWAGA: nawet referencje do obiektow NIE SA ustawiane na null
 *    przed uzyciem ZAWSZE trzeba je zanicjowac
 */
class Local {

  String instant;
  boolean test;

  public static void main(String[] args) {
    new Local();
  }

  Local() {

    // wszystnie NIEZAINICJOWANE
    int i;
    int j;
    char b;
    boolean k;
    String local;

    if (test) {
      i = 2;
    }
    if (true) {
      j = 2;
    }
    System.out.println(j);      // tutaj ok, chociaz kompilator moglby tego nie puscic....
    
    System.out.println(i);      // compile error: zmienne moze nie byc zainicjowana
    System.out.println(local);  // jak wyzej
    System.out.println(b);
    System.out.println(k);

    System.out.println(this.instant); // to ok, bo to jest zmienna instancyjna
    this.instant.toLowerCase();       // ale tutaj runtime error (null)
  }
}
