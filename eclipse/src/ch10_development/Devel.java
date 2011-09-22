package ch10_development;
import static java.lang.Math.*;
import static java.lang.Integer.*;

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
