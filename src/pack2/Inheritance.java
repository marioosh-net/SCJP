/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack2;

/**
 *
 * @author muniek
 */
public class Inheritance {

  public static void main(String[] args) {
    Horse h = new Horse();

    // error
    // eat() jest prywatna i nie jest dziedziczona, dlatego nie moze byc wywolana !
    h.eat();


  }
}

class Animal {

  private void eat() {
    System.out.println("Generic Animal Eating Generically");
  }

  void go_packet() {
  }

  protected void go_protected() {
  }

  private void go_private() {
  }

  static void go_stat() {
    
  }
}

class Horse extends Animal {

  Horse() {
  }

  public void horsi() {
    super.go_packet();
    super.go_protected();
    super.go_private(); // error
  }
}


/**
 *
 *
 *
 *
 *
 * przykladzik z interfejsem i dziedziczeniem
 */

interface Testable {

  void test();
}
class T extends Animal implements Testable {
  public void test() {

  }
}

class T2 extends T {
  // tutaj juz nie musi byc redefinicji metody test() !!
  // ale moze byc jej przeslonieta (overriding)
  public void test() {

  }
}

// pulapka!
class T3 extends T implements Testable {
  // tutaj juz nie musi byc redefinicji metody test() !!!!
  // bo jest ona zrobiona w klasie bazowej T, mimo ze jest "implements"
  T3() {
    this.test(); // ok
  }
}
