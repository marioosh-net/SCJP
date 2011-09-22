/**
 * szkolenie zeto
 * @author marioosh
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

		
		Integer i1 = 0L;
		
		// rozne typy (Integer nie IS-A Long)
		Long l2 = new Integer(0);
		int k = new Integer(0);
		Double s = 2d;
		Integer i3 = new Integer(1) + new Integer(2);
		Integer i4 = 0 + new Long(1);
		int sss= new Integer(0) + new Float(0);
		new Integer(0)++;
		Integer i5 = 0; i5 ++;
		Long l6 = 0 + new Integer(2);

		
		/**
		 * "trójpalczasta"
		 */
		// max z 0 i 0.0 jest typem ktory musi pasowac do long l
		long l = true ? 0 : 0.0;	// cannot convert from double to long
		long l44 = true ? 0.0 : 0;	// to samo
		double d4 = true ? 0 : 0.0;	// juz OK
		
		int x = (int)1d/2;	// => 0 (castowanie silniejsze)
	}
}
