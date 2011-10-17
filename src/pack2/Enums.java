/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack2;

import java.io.Serializable;

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
		Animals.DOG.sound = "HAU"; // ok
		
		System.out.println(Seasons.SUMMER.name());
		System.out.println(Seasons.WINTER.getK());
	}
}

enum Seasons {
	SUMMER, WINTER(1);
	int k;
	String name;
	Seasons() {}
	Seasons(int k) {
		this.k = k;
	}
	public int getK() {
		return k;
	}
	
	/*
	 * name() is final, nie mozna nadpisac tej metody
	 * 
	public String name() {}	*/
	
}
