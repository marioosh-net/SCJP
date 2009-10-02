/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author muniek
 */
public class Book {
  Book(int i) {
    System.out.println("Book created");
  }
}

class MyBook extends Book {

  public static void main(String[] args) {
    new MyBook();
    // domyslnie kompilator doda do tej klasy konstruktor bezargumentowy, w ktorym
    // wywola super(), a poniewaz nie ma w superklasie konktruktora bezargumentowego
    // (kompilator dodalby go, gdyby nie byl zdefiniowany zaden inny) to wystapi blad.
  }
}

