/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgA;

/**
 * 
 * @author muniek
 */
public class Foo {
	int a = 5; 				// domyslnie dostep pakietowy
	protected int b = 6; 	// dostępna tak jak pakietowo, ale rowniez poza pakietem w klasach dziedziczących
	public int c = 7;		// dostępna zewsząd
}
