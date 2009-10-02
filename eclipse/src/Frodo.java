
public class Frodo extends Hobbit {

  public static void main(String[] args) {
    Short myGold = 7;

    // ERROR!
    // countGold nie ma byc z czego wywolany!
    // nie ma tutaj this (nie ma obiektu)
    System.out.println(countGold(myGold, 6));

    System.out.println(countGold_static(myGold, 6)); // OK! bo static

    //
    Hobbit a = new Hobbit();
    a.countGold(2, 1);
    new Tester().funcTester();
  }

  void test() {}
}

class Hobbit {

  int countGold(int x, int y) {
    return x + y;
  }
  static int countGold_static(int x, int y) {
    return x + y;
  }
}

class Rectangle {

  public static void main(String[] args) {

  }
}

class Tester {
  public void funcTester() {
    
  }
}