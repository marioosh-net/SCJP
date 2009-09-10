/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack2;


/**
 *
 *
 *
 *
 *
 * Simple enum
 */
enum Bool {
  // lista musi byuc pierwsza !!!

  HIGH(1), LOW(0);
  private int val;

  Bool(int val) {
    this.val = val;
  }
}

/**
 *
 *
 *
 * Example 2
 */
enum Animals {

  DOG("woof"), CAT("meow"), FISH("burble");
  String sound;

  Animals(String s) {
    sound = s;
  }
}

class Enums {

  static Animals a;

  public static void main(String[] args) {
    System.out.println(a.DOG.sound + " " + a.FISH.sound);
  }
}
