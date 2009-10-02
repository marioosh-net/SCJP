/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muniek
 */
public class Exceptions {

  void test() {
    this.doExceptions();
  }
  
  void doExceptions() {
    try {

    } catch (java.lang.ArithmeticException e) {

    } catch (java.lang.ArrayStoreException e) {

    }
  }
}

class Subclass extends Exceptions {
  void doExceptions() throws java.lang.ArithmeticException, java.lang.ClassCastException {

  }
}