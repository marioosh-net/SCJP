package ch5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * Exceptions
 *
 * ZASADY:
 *  finally: blok zostanie wykonany ZAWSZE (gdy byl i gdy nie bylo wyjatku) !!
 *
 *  kilka blokow catch() { }
 *    - kilka Exceptions'ow w jednym catch'u musi byc zrobione od bardziej szczegolowych do
 *    bardziej ogolnych (jakby odwrotnie niz w hierachii dziedziczenia w diagramie klas -
 *    tzn. jesli wyzszy catch() juz zlapie dane Exception, to nizszy catch() nie moze tego
 *    samego Exception lapac.
 *    - moze byc kilka w dowolnej kolejnosci, jesli sa na tym samym poziomie w drzewie dziedziczenia
 *      np. java.lang.ClassCastException i java.lang.ArithmeticException obie klasy dziedzicza z
 *      java.lang.RuntimeException.
 *    - moze byc kilka w dowolnej kolejnosci jesli nie sa "spokrewione" w dol lub w gore
 *    - If one Exception class is not a subtype or supertype of the other, then the order in which
 *      the catch clauses are placed doesn't matter.
 *
 *    - the exceptions that a method can throw must be declared (unless
 *      the exceptions are subclasses of RuntimeException)
 * 
 *   PODDSTAWOWA ZASADA:
 *    - Each method must either handle all checked exceptions by supplying a catch clause or
 *      list each unhandled checked exception as a thrown exception.
 *
 * Hierachia (dziedziczenie):
 * 
 *  java.lang.Object
 *    |- java.lang.Throwable
 *        |- java.lang.Exception 
 *            |- java.lang.RuntimeException (np. java.lang.ArithmeticException)
 *
 * Error
 * java.lang.Object
 *  |- java.lang.Throwable
 *      |- java.lang.Error (np. java.lang.OutOfMemoryError)
 */
public class Exceptions {

  public static void main(String[] args) {
    new Exceptions();
  }

  Exceptions() {
    System.out.println("# Exceptions #");

    /**
     * KOLEJNOSC definiowania kilku blokow catch
     */
    try {
      int i = 10;
      i = i / 0;
    } catch (java.lang.ArithmeticException e) { // od bardziej szczegolowych wyjatkow...
      e.printStackTrace();
    } catch (Exception e) {                     // do bardziej ogolnych !!! (zawsze, bo compilation fails)
      e.printStackTrace();
    } finally {
      System.out.println("sprzatanie po wyjatku lub nie bylo wyjatku");
    }

    System.out.println("ciag dlaszy programu");

    /**
     * mozliwe jest cos takiego (finally bez catch)
     */
    try {
      // do stuff
    } finally {
      //clean up
    }

    try {
      int w = 10;
      double w1 = w / 0.0;
      System.out.println(w1);
    } catch (java.lang.ClassCastException e) {
    } catch (java.lang.ArithmeticException e) { // compilation error - wyjatek zostal juz przechwycony (wyzej)
    }
    
    // WYJATEK od wykonania bloku finally - brutalne przerwanie programu
    try {
    	System.exit(0);
    } catch (Exception e) {
    } finally {
    	// to sie nigdy nie wykona
    }
    
    // UWAGA:
    try {
    	throw new FileNotFoundException();
    	int k = 1;	// Unreachable code !!!
    } catch (Exception e) {
    	
    }
    
    try {
    	File f = new File("sss");
    } catch (Exception e) {
    	
    }
    
    // ZLE - nie mozemy sprawdzac CheckedException, ktory nigdy nie wystapi
    // ale mozemy tak sprawdzac UnCheckedException
    try {
    	File f = new File("test.t");
    } catch (IOException e) {
    	
    }
  }
}

/**
 * Throwing exceptions
 *
 * ZASADA:
 *  "catch or declare":
 *    Each method must either handle all checked exceptions by supplying a catch clause or
 *    list each unhandled checked exception as a thrown exception.
 *
 */
class Lamp {

  public static void main() {
    try {
      new Lamp().funcOK();
    } catch (Exception e) {
    }

    new Lamp().funcOK(); // error - funcOK rzuca wyjatek, ktory trzeba tutaj obsluzyc
  }

  // nie przechwytuje ale dekraluje wyjatek, ktory poleci do miejsca wywolania metody
  void funcOK() throws java.io.IOException {
    throw new java.io.IOException();
  }

  // nie deklaruje ale przechwytuje wyjatek
  void funcOK2() {
    try {
      throw new java.io.IOException();
    } catch (java.io.IOException e) {
    }
  }

  // nie deklaruje a rzuca wyjatek, ktorego nie przechwutuje - ZLE!
  void funcNOTok() {
    throw new java.io.IOException(); // error
  }

  // nie deklaruje a rzuca (rethrow) wyjatek, ktorego nie przechwutuje - ZLE!
  void funcNOTok2() {
    try {
    } catch (Exception e) {
      try {
        throw e; // error
      }
    }
  }

  void funcOK3() {
    try {
    } catch (Exception e) {
      try {
        throw e; // error
      } catch (Exception ex) {
        // ...
      }
    }
  }
}

/**
 * wyjatek od reguly "catch or declare": Error, RuntimeExceptions (unchecked exceptions)
 *
 *  wyjatek do tej reguly to Erorr i RuntimeException (wraz z podklasami):
 *    RuntimeException, Error, and all of their subtypes are unchecked exceptions
 *    and unchecked exceptions do not have to be specified or handled
 *
 *  checked exceptions  - sprawdzane przez kompilator
 *  unchecked exceptions  - nie sprawdzane przez kompilator (RuntimeEx.., Error)
 */
class Runtime {

  public static void main() {
    new Runtime().funcOK();
    new Runtime().func3OK();
  }

  // deklaruje i rzuca wyjatek, a kompilator nie wymaga zeby go lapac
  void funcOK() throws java.lang.RuntimeException {
    throw new RuntimeException();
  }

  // nie deklaruje a rzuca wyjatek - tez dozwolone dla RuntimeException i Error
  void funcOK2() {
    throw new RuntimeException();
  }

  void func3OK() {
    throw new Error(); // unchecked, nie musi byc lapane
  }
}

/**
 * Custom Exceptions
 *  by extends
 */
class MyException extends Exception {
}

class MyUnCheckedException extends java.lang.RuntimeException {
}

class TestMyEx {

  static public void main(String[] args) {
    new TestMyEx();
  }

  TestMyEx() {
    try {
      doit();
    } catch (Exception e) {
    }
    doit2();
  }

  void doit() throws MyException {
  }

  void doit2() throws MyUnCheckedException {
  }
}

/**
 * Rethrowing
 */
class Rethrow {

  // rzucamy wyjatek ktorego ani nie przechwutujemy ani nie deklarujemy
  void test() {
    try {
    } catch (Exception e) {
      throw e;
    }
  }

  // tutaj juz wyjatek jest zdeklarowany
  void testOK() throws Exception {
    try {
    } catch (Exception e) {
      throw e;
    }
  }
}

/**
 *
 *
 * 
 * Common Exceptions and Errors
 *
 * ZASADA:
 *  - wyjatek wywala JVM (JVM exceptions) lub program (Programmatic exceptions)
 */
class JVMExceptions {

  static public void main(String[] args) {
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
  static int[] x = new int[4];


  static {
    x[4] = 5; // --> ExceptionInInitializerError
  }

  // java.lang.NoClassDefFoundError
  // zazwyczaj przy uruchamianiu aplikacji (np. z linii polecen)
}

class ProgrammaticExceptions {

  static public void main(String[] args) {
  }

  // IllegalArgumentException
  void test(int a) {
    int x = 5;
    if (a == 0) {
      throw new IllegalArgumentException();
    }
    x = 5 / a;
  }

  // IllegalStateException
  void state() {
  }

  // java.lang.NumberFormatException
  void number() {
    int x = Integer.parseInt("dupa"); // --> NumberFormatException
  }

  // java.lang.AssertionError
  void assertion() {
    int num = -1;
    assert (num < 0); // --> AssertionError jesli test nie jest true
  }
}

// produce: -ic mc mf of
class Emu {

  static String s = "-";

  public static void main(String[] args) {
    try {
      throw new Exception();
    } catch (Exception e) {
      try {
        try {
          throw new Exception();
        } catch (Exception ex) {
          s += "ic ";
        }
        throw new Exception();
      } catch (Exception x) {
        s += "mc ";
      } finally {
        s += "mf ";
      }
    } finally {
      s += "of ";
    }
    System.out.println(s);
  }
}


/**
 * Overriding and Exceptions
 * ZASADA:
 *    metoda przeslaniajaca (w podklasie) nie moze rzucac bardziej ogolnego wyjatku
 *    niz metoda przyslaniana (w klasie bazowej), odwrtonie tak.
 */

class Base {
  void func() throws IndexOutOfBoundsException {}
  void func2() throws Exception {}
}

class SubBase extends Base {
  void func() throws Exception {} // overriden method doesn't throw java.lang.Exception
  void func2() throws IndexOutOfBoundsException {}
}

