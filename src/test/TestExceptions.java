/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author muniek
 */
public class TestExceptions {

  static public void main(String[] args) {
    new TestExceptions();
  }

  TestExceptions() {
    new JVMExceptions().main(null);
  }
}

class JVMExceptions {

  static public void main(String[] args) {

    int num = 1;
    assert (num >= 2); // --> AssertionError jesli test nie jest true

    int x = Integer.parseInt("dupa"); // --> NumberFormatException
    new JVMExceptions().classC();

    JVMExceptions c = new JVMExceptions();
    c = null;
    c.func(); // --> NullPointerException

    JVMExceptions c2 = new JVMExceptions();
    c2.func2(); // --> StackOverflowException
  }

  void func() {
  }

  // StackOverflowException
  void func2() {
    func2();
  }

  // java.lang.ArrayIndexOutOfBoundsException
  void func3() {
    int arr[] = new int[4];
    arr[4] = 5; // --> ArrayIndexOutOfBoundsException
  }

  // java.lang.ClassCastException
  void classC() {
    Object x = new Object();
    String y = (String) x; // Object is-NOT-a String
  }

  // java.lang.ExceptionInInitializerError
  /*
  static int[] x = new int[4];
  static {
  x[4] = 5; // --> ExceptionInInitializerError
  }*/
  // java.lang.NoClassDefFoundError
  // zazwyczaj przy uruchamianiu aplikacji (np. z linii polecen)
}