/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch5;

/**
 *
 * assertions are disabled at runtime by default, to enable:
 *  java -ea .... (kopilacja z wlaczonymi asercjami)
 *  java -enableassertions ...
 * to disable:
 *  java -da ...
 *  java -disableassertions ...
 *
 * wybiorcze wlaczania/wylaczanie asercji dla pakietow/klas:
 *  java -ea -da:com.geeksanonymous.Foo  
 *  java -ea:com.geeksanonymous
 *  java -ea:com.foo... // (3-kropki) enable rowniez dla PODpakietow
 *
 * syntax:
 *  assert <boolean expressions>;
 *  assert <boolean expressions> : <value to print in the stack trace (String, object, int....)>;
 */
public class Assertion {

  static public void main(String[] args) {

    new Assertion();
  }

  Assertion() {
    int x = 2;
    int y = 1;

    // sposob 1
    // wyrzuci  wyjatek java.lang.AssertionError
    assert (y > x);

    // sposob 2
    // wyrzuci  wyjatek java.lang.AssertionError z dopiskiem x = 2, y = 1
    assert (y > x) : "x = " + x + ", y = " + y;

  }

  // przyklady dobre i zle
  void examples() {
    int x = 1;
    boolean b = true;
    // the following six are legal assert statements
    assert (x == 1);
    assert (b);
    assert true;
    assert (x == 1) : x;
    assert (x == 1) : aReturn();
    assert (x == 1) : new ValidAssert();
    assert (b = false); // nieczytelne ale poprawne!
    assert (b = true);  // jw.

    // the following six are ILLEGAL assert statements
    assert (x = 1); // none of these are booleans
    assert (x);
    assert 0;
    assert (x == 1) : ; // none of these return a value
    assert (x == 1) : noReturn();
    assert (x == 1) : ValidAssert va;

    // od wersji 1.4 assert is a keyword!!!
    // javac -source 1.3 OldCode.java // Code compiles with warnings.
    int   assert = true;
  }

  void noReturn() {
  }

  int aReturn() {
    return 1;
  }
}

/**
 * odpowiednie (appropriate) i nieodpowiednie (inappropriate) uzycie asercji
 * (ale legalne!!!)
 */
class GoodBad {
  int x;
  int y;

  static public void main(String[] args) {
    assert args.length > 0; // NIEodpowiednie - nie uzywac do sprawdzania parametrow wejsciowych
    new GoodBad();
  }

  GoodBad() {
  }

  // NIEodpowiednie - sprawdzanie parametrow metody publicznej
  public void doStuff(int x) {
    assert (x > 0); // inappropriate !
  }

  // odpowiednie - sprawdzanie parametrow metody prywatnej
  private void doMore(int x) {
    assert (x > 0); // inappropriate !
  }

  // NIEodpwiednie - przy asercji cos zmieniamy!!
  public void doStuff() {
    assert (modifyThings());
    // continues on
  }

  public boolean modifyThings() {
    y = x++;
    return true;
  }
}
