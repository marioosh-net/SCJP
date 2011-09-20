/**
 * szkolenie zeto
 * @author ZETO
 *
 */
public class Szkolenie {
	public static void main(String[] arg) {
		
		// 0.0 to double
		double a = -0.0;
		double b = +0.0;
		if (a == b) {
			System.out.println("rowne");
		} else {
			System.out.println("rozne");
		}

		int d = 0;
		double c = 0;
		c = c/0;	// NaN
		System.out.println(c);
		if(c < 0 || c > 0 || c == 0) {
			System.out.println("XA");
		} else {
			System.out.println("XB");
		}
		
		c = 1;
		c = c/0;	// Infinity
		System.out.println(c);
		

	}
}
