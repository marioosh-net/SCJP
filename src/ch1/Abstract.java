package ch1;

/**
 *
 * @author muniek
 */
public class Abstract {

}

/**
 * Abstract Classes
 */
// remember that if even a single method is abstract, the whole class must be declared abstract
abstract class B {

  B() {
    System.out.println("make B");
    this.testB();
  }

  final void cantChangeIt() {
  }


  void testB() {
    System.out.println("testB");
  }

  // abstract method cannot have a body
  // abstract void ab() {};
  abstract void ab();
}

class C extends B {

  String test;

  void testB() {
    System.out.println("testB_override");
    this.cantChangeIt();
  }

  void ab() {
  }
}

abstract class Abstract1 {

  abstract void abstractF1();

  abstract void abstractF2();
}

// tu nie musi byc implementacji metod bo klasa jest abstact
abstract class Abstract2 extends Abstract1 {

  abstract void abstractF3();
}

// tu juz musi byc implementacja metod bo klasa NIE jest abstact
class NotAbstract1 extends Abstract2 {

  void abstractF1() {
    int i = 1;
  }

  void abstractF2() {
  }

  void abstractF3() {
  }

  // overloading (przeciazenie)
  void abstractF3(int i) {
  }

  void doStuff(int... x) {
    System.out.println(x[0]);
  }
}

abstract class T {

  protected abstract void do1();

}

class TT extends T {
  // za slaby atrybut dostepu w stosunku do dziedziczonej kl. abstrakcyjnej
  /*
  void do1() {}
  private void do1() {}
   */


  // te definicje sa ok
  public void do1() {
  } /*
  protected void do1() {}*/

}
