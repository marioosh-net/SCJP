
/**
 *
 * @author muniek
 */
public class Constructors3 {
  static public void main(String[] a) {
    new New();
  }
}

/**
 *
 *
 * kazda klasa, nawet abstrakcyjna ma przynajmniej jeden konstruktor
 */
abstract class IhaveContructor {

  IhaveContructor() {
    // it's ok
    this(1);
    System.out.println("1 [constructor]");
  }

  IhaveContructor(int i) {
    // it's ok
    System.out.println("2 [constructor]");
  }
}

class New extends IhaveContructor {
  New() {
    System.out.println("New [constructor]");
  }
}