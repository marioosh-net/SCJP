
public class Overloading_Overriding {

  static public void main(String[] a) {
    new Over1().one(1);

  }
}

class Over1 {

  void one(int i) {
    System.out.println("A");
  }

  void one(int... i) {
    System.out.println("B");
  }
  /**
   *
   * to samo to:
   *
   *
  void one(int[] i) {
  System.out.println("B");
  }*/
}

/**
 *
 *
 *
 *
 *
 * Example 2
 */
class Animal {
}

class Horse extends Animal {
}

class UseAnimals {

  public void doStuff(Animal a) {
    System.out.println("In the Animal version");
  }

  public void doStuff(Horse h) {
    System.out.println("In the Horse version");
  }

  public static void main(String[] args) {
    UseAnimals ua = new UseAnimals();
    Animal animalObj = new Animal();
    Horse horseObj = new Horse();
    ua.doStuff(animalObj);
    ua.doStuff(horseObj);

    // typ referencji w parametrach decyduje ktora metoda jest wywolywana, 
    // nie to ze referencja wskazuje np. na obiekt podklasy
    Animal animalRefToHorse = new Horse();
    ua.doStuff(animalRefToHorse); // tutaj pojdzie: doStuff(Animal a)
  }
}

/**
 * 
 * 
 * 
 * 
 * 
 * Example 3: Polimorfizm i metody przeciazane i przeslaniane
 *
 * To summarize, which overridden version of the method to call (in other words, from
 * which class in the inheritance tree) is decided at runtime based on object type, but
 * which overloaded version of the method to call is based on the reference type of
 * the argument passed at compile time.
 *
 * podczas wykonywania podejmowana jest decyzja ktora przeslonieta metoda sie wykona na podstawie
 * typu obiektu na ktory referencja wskazuje (nie koniecznie ten sam typ co sama referencja! - polimorf.)
 * natomiast podczas kompilacji ktora perzeciazona metoda sie wykona na podstawie typu
 * przekazywanych parametrow.
 *
 * inaczej: typ obiektu decyduje o tym ktora z metod przeslonietych sie wykona
 *          typ referencji decyduje o tym ktora z metod przeciazonych sie wykona
 */
class Animal2 {

  public void eat() {
    System.out.println("Generic Animal Eating Generically");
  }
}

class Horse2 extends Animal2 {

  public static void main(String[] args) {
    Animal2 a = new Animal2();
    a.eat();

    Horse2 h = new Horse2();
    h.eat();

    Animal2 ah = new Horse2();
    ah.eat();

    Horse2 he = new Horse2();
    he.eat("Apples");

    // ERRORS:
    // wywolania polimorficzne na obiekcie Animal2 nie ma metody eat()
    Animal2 a2 = new Animal2();
    a2.eat("treats"); // Animal2 nie ma metody eat(String)

    Animal2 ah2 = new Horse2();
    ah2.eat("Carrots"); // Animal2 nie ma metody eat(String), mimo ze polimorficznie zostalaby
  // wywolana eat(String) dla Horse2, ktora rzeczywiscie jest
  // JAK WIDAC: referencja ah2 decyduje!!!!
  }

  // przesloniecie
  public void eat() {
    System.out.println("Horse eating hay ");
  }

  // przeladowanie
  public void eat(String s) {
    System.out.println("Horse eating " + s);
  }
}

/**
 *
 *
 *
 * return type in overriding
 */
class Alpha {

  Alpha doStuff(char c) {
    return new Alpha();
  }

  Beta retInt() {
    return null;
  }
}

class Beta extends Alpha {
  // jesli zwracany typ jest podtypem przeslanianej metody,
  // to jest to rowniez przesloniecie (overriding) - OK (tylko w javie 1.5!!!)

  Beta doStuff(char c) {     // legal override in Java 1.5, tzw. covariant returns
    return new Beta();
  }

  // w tym momencie to jest zle, bo jest druga proba przesloniecia tej samej metody
  Alpha doStuff(char c) {
    return new Alpha();
  }

  // tak juz zle. bo zwrcamy bardziej ogolny typ
  Alpha retInt() {
    return null;
  }
}

/**
 *
 *
 *
 * Typy zwracane przez metody
 * 
 * PODSTAWOWA ZASADA:
 *    jak X IS-A Y to metoda moze zwracac X, mimo ze w sygnaturze ma Y
 *    np. Horse IS-A Animal, to metoda: Animal x() moze robic: return new Horse();
 *
 *    inaczej: metoda moze zwracac podtyp (subtype)
 *    
 */
class Returner {
  // zwracane typy

  // ok
  public Animal getAnimal() {
    return new Horse();  // Assume Horse extends Animal, Horse IS-A Animal
  }

  // nie ok
  public Horse getAnimal2() {
    return new Animal();  // Animal is NOT a Horse
  }

  //ale juz ok (dla kompilatora), natomiast ERROR at runtime (Aniaml nie jest Horse!!)
  public Horse getAnimal3() {
    return (Horse) new Animal();  // rzutowanie
  }

  // ok
  Object retOK() {
    int i = 1;
    return i; //int is a Object
  }

  // nie ok
  public int retNotOK() {
    return new Object(); //Object is NOT a int
  }
}

interface Chewable {
}

class Gum implements Chewable {
}

class TestChewable {
  // Method with an interface return type

  public Chewable getChewable() {
    return new Gum();  // Return interface implementer
  }
}

/**
 *
 *
 *
 *
 * Overloading - example 3
 *
 * ZASADA:
 * In every case, when an exact match isn't found, the JVM uses the method with the
 * smallest argument that is wider than the parameter.
 */
class EasyOver {

  static void go(int x) {
    System.out.print("int ");
  }

  static void go(long x) {
    System.out.print("long ");
  }

  static void go(double x) {
    System.out.print("double ");
  }

  static void go2(double x) {
    System.out.print("double ");
  }

  public static void main(String[] args) {
    byte b = 5;
    short s = 5;
    long l = 5;
    float f = 5.0f;
    go(b);  // nie ma metody z parametrem byte, to java bierze metode z szerszym, ale mozliwie
    // najwezszym typem kompatybilnym - tutaj jest to int.
    go(s);  // jak wyzej
    go(l);
    go(f);  // nie ma go(float x){}, to leci metoda z double w parametrze

    // tutaj poleci wszystko na metodzie z double w parametrze
    go2(b);
    go2(s);
    go2(l);
    go2(f);
  }
}

/**
 *
 *
 *
 * Overloading and Boxing
 * 
 * ZASADA:
 * Java wybierze widening zamiast boxing'u :), czyli woli wybrac metode z szerszym zakresem
 *   dla przekazywanego parametru, niz robic boxing, nawet na odpowiadajacym typie
 */
class AddBoxing {

  static void go(Integer x) {
    System.out.println("Integer");
  }

  // Answer: ta metoda sie wywola
  static void go(long x) {
    System.out.println("long");
  }

  public static void main(String[] args) {
    int i = 5;
    go(i); // which go() will be invoked?
  }
}

/**
 *
 *
 *
 * I znowu ciekawy przypadek i zasada:
 * ZASADA:
 *    widening wybierany jest przed metodami z nieokreslona liczba argumentow (var-args)
 *
 * Podsumowujac te dwa przyklady:
 *    ■ Widening beats boxing
 *    ■ Widening beats var-args
 */
class AddVarargs {

  static void go(int x, int y) { // <- ta metoda sie wykona
    System.out.println("int,int");
  }

  static void go(byte... x) {
    System.out.println("byte... ");
  }

  public static void main(String[] args) {
    byte b = 5;
    go(b, b); // which go() will be invoked?
  }
}

/**
 *
 *
 * Boxing vs Widening
 *
 * ZASADA: Boxing beats var-args :)
 */
class BoxOrVararg {

  static void go(Byte x, Byte y) {
    System.out.println("Byte, Byte");
  }

  static void go(byte... x) {
    System.out.println("byte... ");
  }

  public static void main(String[] args) {
    byte b = 5;
    go(b, b); // which go() will be invoked?
  }
}
