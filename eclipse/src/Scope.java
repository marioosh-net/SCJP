/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * kolejnosc zmiennych od najwyzszego zasiegu:
 *    statyczne (juz po zaladowaniu klasy do JVM)
 *    instancyjne (na czas zycia obiektu)
 *    lokalne (tak jak dlugo ich metody sa na stercie)
 *    blokowe (initialization block) - tylko na czas wykonywania bloku
 */
public class Scope {
}

class ScopeErrors {

  int x = 5;

  public static void main(String[] args) {
    x++;   // won't compile, x is an 'instance' variable
  }
}

class ScopeErrors2 {

  public static void main(String[] args) {
    ScopeErrors2 s = new ScopeErrors2();
    s.go();
  }

  void go() {
    int y = 5;
    go2();
    y++;         // once go2() completes, y is back in scope
  }

  void go2() {
    y++;         // won't compile, y is local to go()
  }

  void go3() {
    for (int z = 0; z < 5; z++) {
      boolean test = false;
      if (z == 3) {
        test = true;
        break;
      }
    }
    System.out.println(test);   // 'test' is an ex-variable,
                              // it has ceased to be...
  }
}