package pkgB;

import pkgA.*;

public class Baz {

  public static void main(String[] args) {
    Foo f = new Foo();
    System.out.print(" " + f.a);	// a ma dostêp domyœlny (pakietowy)
    System.out.print(" " + f.b);	// b jest protected, st¹d nie bêdzie dostepny poza drzewem dziedziczenia  
    System.out.println(" " + f.c);	// c jest public, ok
  }
}
