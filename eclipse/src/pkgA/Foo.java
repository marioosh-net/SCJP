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
	protected int b = 6; 	// dostêpna tak jak pakietowo, ale rowniez poza pakietem w klasach dziedzicz¹cych
	public int c = 7;		// dostêpna zewsz¹d
}
