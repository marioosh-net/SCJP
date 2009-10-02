/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muniek
 */
class Animal {
}

class Dog extends Animal {
  void hau(){

  }
}

// downcasting - to more specific class in inheritance tree
public class Downcasting {

  public static void main(String[] args) {
    Animal animal = new Animal();

    // nie ma bledu kompilacji, ale jest blad podczas wykonywania!!
    // ERROR: Animal cannot be cast to Dog !
    try {
      // kompilator puszcza jesli rzutowanie jest w obrebie drzewa dziedziczenia, ale nie sprawdza
      // poprawnosci tego rzutowania, dlatego blad dopiero wyleci podczas uruchamiania
      Dog d = (Dog) animal;
    } catch (java.lang.ClassCastException e) {
      e.printStackTrace();
    }

    // ale tak juz jest ok:
    Animal animal_ = new Dog();
    Dog d_ = (Dog) animal_;
    System.out.println("Animal is not Dog, but Dog is a Animal");
  }
}

// upcasting (to more general type) / rzutowanie do bardziej ogolnego typu
class Upcasting {
  public static void main(String[] args) {
    new Upcasting();
  }
  Upcasting() {
    Dog d = new Dog();
    Animal a = (Animal)d; // jawnie (explicitly)
    Animal b = d;         // niejawnie (implicitly)
  }
}

