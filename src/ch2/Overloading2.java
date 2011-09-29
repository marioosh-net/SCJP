package ch2;

class AnimalX {
}

class HorseX extends AnimalX {
}

public class Overloading2 {

  public void doStuff(AnimalX a) {
    System.out.println("In the AnimalX version");
  }

  public void doStuff(HorseX h) {
    System.out.println("In the HorseX version");
  }

  public static void main(String[] args) {
    Overloading2 o = new Overloading2();
    
    AnimalX animalObj = new AnimalX();
    HorseX horseObj = new HorseX();
    o.doStuff(animalObj);
    o.doStuff(horseObj);

    System.out.println("=== UWAGA ===");
    // typ referencji w parametrach decyduje ktora metoda jest wywolywana, 
    // nie to ze referencja wskazuje np. na obiekt podklasy
    AnimalX animalRefToHorse = new HorseX();
    o.doStuff(animalRefToHorse); // tutaj pojdzie: doStuff(AnimalX a)
  }
}

class A {
	void test() {};
}
class B extends A {
	abstract void test();
}