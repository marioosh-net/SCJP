/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author muniek
 */
public class Oper1 {

  int index = 1;

  static public void main(String[] args) {

    new Oper1().go();
    System.out.println(17 / 0.0);
  }

  void go() {
    int[][] dd = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1, 0}};
    System.out.println(dd[index++][index++]); // dd[1][2]
  }

}

class Feline {

  public static void main(String[] args) {
    Long x = 42L;
    Long y = 44L;
    System.out.print(" " + 7 + 2 + " ");
    System.out.print(foo() + x + 5 + " ");
    System.out.println(x + y + foo()); // UWAGA! od lewej do prawej... wiec pierwsze jest dodanie!!!
  }

  static String foo() {
    return "foo";
  }
}
