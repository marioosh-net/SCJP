
import package1.*;

public class NewClass {

  NewClass() {
    Public p = new Public();

    // protected
    //p.func(); //error

    // static tiger variable
    System.out.println(Test.tiger);

  }
}

/**
 *
 *
 *
 *
 *
 * protected members - WAZNE
 */
class Ext extends Public {

  private int i;

  Ext() {
    // protected func2 przechodzi bo jest dziedziczona
    this.func2();
  }

  // klasa wewnetrzna (ma dostep do skladowych dziedziczonych!)
  class Y {

    Y() {
      Ext e = new Ext();
      i = 1; // dostep do prywatnych memborow klas otaczajacych
      // OK
      e.func2();
    }
  }
}

// klasa zewnetrzna (nie dziedziczy z Public ani Ext wiec nie ma dostepu do protected func2())
class X {

  X() {
    Ext e = new Ext();

    // UWAGA!
    // protected func2 - tutaj nie przechodzi :(
    //e.func2();
  }
}
