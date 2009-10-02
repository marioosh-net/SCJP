/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author muniek
 */
public class Widening {

  public static void main(String[] args) {
    Integer i = 010;
    increment(i);
    System.out.println(i);
  }

  static void increment(Long x) {
    x++;
  }
  static void dec(int x) {
    
  }
}

/*8
  9
  10
  11
  Compilation fails
 *
 * Compilation fails in line none of the wrapper classes will widen from one to another!
   In this example Integer can't be widen to Long
*/