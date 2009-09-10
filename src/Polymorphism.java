/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muniek
 */
public class Polymorphism {

  public static void main(String[] args) {
    C c = new C();
    D d = new D();

    A a;
    
    a = c;
    a.doA();  // tutaj wywola sie wersja doA() dla c
    a = d;
    a.doA(); // tutaj wywola sie wersja doA() dla d
  }
}

interface A {
  void doA();
}

class C implements A {

  public void doA() {
    System.out.println("doA by C");
  }
}

class D implements A {

  public void doA() {
    System.out.println("doA by D");
  }
}



