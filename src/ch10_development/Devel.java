package ch10_development;
import static java.lang.Math.*;
import static java.lang.Integer.*;

import static java.lang.Integer;	// statycznie mozna importowac tylko membery i stale/zmienne
import java.lang.Integer;			// ale tak oczywiscie ok
import static java.lang.Integer.MAX_VALUE;

public class Devel {
	public static void main(String[] args) {
		new Devel();
	}
	
	public Devel() {
		
		/**
		 * import static dal nam mozliwosc dostawania sie do metod i pol bezposrednio
		 */
		cos(2);
		Math.cos(2);	// rownoznaczne
		
		/**
		 * podobnie dostajemy sie do stalych
		 */
		System.out.println(MAX_VALUE);
		
	}
}
