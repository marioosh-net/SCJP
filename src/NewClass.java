
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

  Ext() {
    // protected func2 przechodzi bo jest dziedziczona
    this.func2();
  }

  // klasa wewnetrzna
  class Y {

    Y() {
      Ext e = new Ext();

      // OK
      e.func2();
    }
  }
}

// klasa zewnetrzna
class X {

  X() {
    Ext e = new Ext();

    // UWAGA!
    // protected func2 - tutaj nie przechodzi :(
    // e.func2();
  }
}
