package ch3;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Bloki niestatycznie odpalane sa zaraz po super() przy kazdym tworzeniu obiektu
 *    uzywane najczesciej do wykonywania kodu wspolnego dla wszystkich konstruktorow
 *
 * Bloki statyczne odpalane sa raz, kiedy klasa jest ladowana
 *
 */
public class InitializationBlocks {

  static int x;
  int y;
  static final int z = 2;
  final int z1;

  public static void main(String[] args) {
    new InitializationBlocks();
  }


  static {
    x = 7;
    System.out.println("static init");
  } // static init block

  static {
    z = 1;
  }

  {
    // w bloku inicjalizac. mozna zmienic zmienna final, ale jesli nie jest ustawiona!!!!
    z1 = 2; 
  }

  {
    y = 8;
    System.out.println("1st instance init");
  } // instance init block


  {
    System.out.println("2nd instance init");
  }


  {
    // bledny init wyrzuca wyjatek java.lang.ExceptionInInitializerError
    int[] t = new int[4];
    t[4] = 1;
  }
}

