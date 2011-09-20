package ch3;
import ch2.Animal;
import ch2.Dog;


public class Arrays {

  public static void main(String[] args) {
    new Arrays();
  }

  Arrays() {
    /**
     *
     * declarations
     */
    int[] tab1; // recommended
    int tab2[];
    int[] tab3;
    int[] tab7;
    // multi-dimensional
    int[] tab4[];
    int[] tab5[];
    int[][] tab6; // recommended

    /**
     * 
     * constructing (definitions)
     */
    tab1 = new int[10];
    char tab8[] = new char[10];

    byte[] err = new byte[]; // error, zawsze przy tworzeniu musi byc rozmiar
    int c = 10;
    byte[] b = new byte[c];

    // UWAGA: kontuktor nie jest wywolywany! - jeszcze. Tworzony jest obiekt tablicy.
    // tablica zawiera jedyne 4 referencje, nie same obiekty
    Object[] ob = new Object[4];

    //multi
    int[][] Tab = new int[2][];
    int[][] Tab1 = new int[][2
    ]    ; // ZLE!

    /**
     *
     * initialization
     */
    Animal[] pets = new Animal[3];
    pets[0] = new Animal();
    pets[1] = new Animal();
    pets[2] = new Animal();

    int[] x = new int[5];
    x[7] = 3; // runtime ArrayIndexOutOfBoundsException // compile ok

    int[][] scores = new int[2][];
    scores[0] = new int[4];
    scores[1] = new int[6];

    // length (public)
    System.out.println(scores.length);

    /**
     *
     *
     * definicja, tworzenie i inicjalizacja w jednym
     */
    // primitives
    int l = 7;
    int[] dots = {6, l, 8};
    int[][] scores1 = {{5, 2, 4, 7}, {9, 2}, {3, 4}};
    // objects
    Dog puppy = new Dog("Frodo");
    Dog[] myDogs = {puppy, new Dog("Clover"), new Dog("Aiko")};

    // by anonymous array
    int[] testScores;
    testScores = new int[]{4, 7, 2};

    int[][] u;
    u = new int[][]{};
    System.out.println("u.length: " + u.length); // u.length: 0

    // ale tak jest zle
    u = new int[2][]
    {
      {
        1,2
      }
      ,
      {
        2,3
      }
    }
    ;  // nie mozna podawac rozmiaru, gdy jest inicjalizacja
    u = new int[][]{{1, 2}, {2, 3}};     // inicjalizacja dla tablicy 2-wymiarowej


    // interfejs jako typ tablicowy
    Sporty[] sportyThings = new Sporty[3];
    sportyThings[0] = new Ferrari();

    /**
     *
     * Assignments
     * przypisywanie tablic
     *
     * ZASADA:  - dla prymitywow nie mozna mieszac typow przy przypisywaniu sobie referencji tablicowych
     *          - dla obiektow mozna w obrebie drzewa dziedziczenia
     * nnie mozna referencji do tablicy int'ow przypisac tablicy char'ow
     * natomiast mozna do tablicy Animal[] przypiscac tablice Cat[]
     */

    // tak sie nie da
    int[] splats;
    int[] dats = new int[4];
    char[] letters = new char[5];
    splats = dats; // OK, dats refers to an int array
    splats = letters; // NOT OK, letters refers to a char array
    // ...chociaz tak sie da
    int a1 = 1;
    char b1;
    a1 = b1;

    // tak sie da
    Animal[] animals = new Animal[2];
    Cat[] cats = new Cat[2];
    animals = cats;
    // podobnie jak tak sie da
    Animal animal1 = new Animal();
    Cat cat1 = new Cat("Tobi");
    animal1 = cat1;

  }
}

class Animal {
}

class Dog {

  Dog(String name) {
  }
}

class Cat extends Animal {

  Cat(String name) {
  }
}

class Car {
}

interface Sporty {

  void beSporty();
}

class Ferrari extends Car implements Sporty {

  public void beSporty() {
  }
}