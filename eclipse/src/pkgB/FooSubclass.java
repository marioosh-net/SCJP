/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgB;

import pkgA.Foo;

/**
 * 
 * @author muniek
 */
public class FooSubclass extends Foo {
	public FooSubclass() {
		b = 2; // ok, bo FooClass dziedziczy z Foo
		a = 1; // pakietowy dostep
		
		/**
		 * UWAGA! The subclass can see the protected member only through inheritance.
		 */
		Foo f = new Foo();
		f.b = 3; 
		
		Foo f2 = new FooSubclass();
		((FooSubclass)f2).b = 3;	// teraz juz ok
	}
}

class FooSubclass2  {
	public FooSubclass2() {
		b = 2; // zle, bo FooClass2 NIE dziedziczy z Foo
	}
}
