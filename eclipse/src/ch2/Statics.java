package ch2;
//import Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muniek
 */
public class Statics {

  static String staticVar = "Ala";
  String instanceVar = "Tola";

  static boolean isStatic() {
    return true;
  }

  public static void main(String[] a) {
    System.out.println(staticVar);      // ok
    System.out.println(this.staticVar); // error (nie mozna uzyc this w statycznej metodzie)

    System.out.println(instanceVar); // error (niestatyczna zmienna nie moze byc uzyta w staycznej metodzie)

    // ok, odwolujemy sie do konkretnego obiektu
    System.out.println(new Statics().staticVar);
    System.out.println(new Statics().instanceVar);

    new Statics().staticVar = "Aleksandra";
    System.out.println(new Statics().staticVar); // statyczna zmienia sie dla wszystkich obiektow (w jednym miejscu)


    // dostep do statycznej zmiennej/metody bez tworzenia obiektu
    Statics.staticVar = "Wiktor";
    Statics.isStatic();
  }
}

/**
 *
 *
 *
 * Redefinicja metody klasycznej
 * NIE przesłonięcie (overriding)
 *
 * ZASADA: statyczne metody nie moga byc przysloniete
 *        mozna je zredefiniowac, ale to juz osobna metoda
 *        nie zadziala tutaj polimorfizm
 */
class MoreStatics extends Statics {

  static boolean isStatic() {
    staticVar = "Wacław";
    return true;
  }

  static public void main(String[] a) {
    new Statics().isStatic();
    System.out.println(staticVar);
    new MoreStatics().isStatic();
    System.out.println(staticVar);

    Statics s = new MoreStatics();
    s.isStatic(); // tutaj wywola sie metoda dla Statics, nie dla MoreStatics (wazna jest referencja)
    // to oznacza ze statyczne metody nie moga byc przesloniete, tak jak ponizej:
    Test t = new Test2();
    t.isNotStatic(); // tutaj wywola sie polimorficznie metoda dla Test2.
  }
}

class Test {

  void isNotStatic() {
    System.out.println("doit Test");
  }
}

class Test2 extends Test {

  void isNotStatic() {
    System.out.println("doit Test2");
  }
}