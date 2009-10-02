/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muniek
 */
public class TestDays {

  public enum Days {

    MON, TUE, WED
  };

  public static void main(String[] args) {
    
    for (Days d : Days.values()) {
      System.out.println(d);
    }
    Days[] d2 = Days.values();
    System.out.println(d2[2]);
  }
}