package pkgB;

import pkgA.*;

public class Baz {

  public static void main(String[] args) {
    Foo f = new Foo();
    System.out.print(" " + f.a);	// a ma dost�p domy�lny (pakietowy)
    System.out.print(" " + f.b);	// b jest protected, st�d nie b�dzie dostepny poza drzewem dziedziczenia  
    System.out.println(" " + f.c);	// c jest public, ok

  }
}
