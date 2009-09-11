

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

