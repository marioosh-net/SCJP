package ch3;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muniek
 */
public class Assigning {

  static public void main(String[] args) {

    new Test();
  }
}

class X {

  int memb;
}

class Test {
  // referencje

  X a;
  X b;

  //primirives
  int i;
  int j;

  Test() {
    // na prymitywnych wartosci sa KOPIOWANE
    i = 10;
    j = i;
    System.out.println("j: " + j);
    j = 2;
    System.out.println("i: " + i);
    System.out.println("j: " + j);

    // na referencjach zmienia sie to na co wskazuja referencje
    // referencje sa kopiowane, i potem mozna przez referencje zmienic obiekt (CIAGLE TEN SAM)
    a = new X();
    a.memb = 0;
    System.out.println("a.memb: " + a.memb);
    b = a;
    b.memb = 5;
    System.out.println("a.memb: " + a.memb);

    // ****** UWAGA ***********
    // WYJATEK od powyzszej reguly: String
    String s1 = "ala";
    String s2;
    s2 = s1;      // tutaj tworzony jest nowy String! i rererencja s2 wskazuje na niego, s1 sie NIE ZMIENIA!!
    s2 = "tomek"; // tutaj nie zminimy obiektu s1 !!!
    System.out.println("s1: " + s1);
    System.out.println("s2: " + s2);

    String s = "Fred";
    String t = s;
    t.toUpperCase();  // tutaj towrzony jest nowy String, ale poniewaz nie przypisujemy go do innego to
                      // on ginie!!!! i faktycznie nie zmieniamy t!
    System.out.println("t: " + t);
    System.out.println("s: " + s);

  }
}