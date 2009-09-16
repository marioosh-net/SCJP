
public class Debug {

  {
    System.out.println("2 instancyjne");
  }  // wykona sie przed utworzeniem obiektu (przed konstruktorem)


  static {
    System.out.println("1 statyczne");
  } // wykona sie jeszcze wczesniej, nawet bez tworzenia obiektu Debug

  Debug() {
    System.out.println("3 kontruktor");
  }

  static public void main(String[] a) {
    new Debug();
  }
}


