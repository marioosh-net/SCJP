/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * @author muniek
 */
public class Test {

  public static int tiger = 1414;

  Test() {
    Public p = new Public();
    p.func2();

    doStuff(1);
    doStuff(1, 2);
  }

 // ok
 static void doStuff(int... doArgs) { } /*
 static void doStuff(int x, int... doArgs) { } */

 /* errors:
 static void doStuff(int doArgs...) { }
 static void doStuff(int... doArgs, int y) { } */

}

