package ch6;

/**
 * format = printf
 * 
 * format string:
 * %[arg_index$][flags][width][.precision]conversionChar
 * ([] - opcjonalne)
 * 
 * gdzie:
 * 
 * conversionChar:
 * - b boolean
 * - c char
 * - d integer
 * - f floating point
 * - s string
 * 
 * flags:
 * - "-" Left justify this argument
 * - "+" Include a sign (+ or -) with this argument
 * - "0" Pad this argument with zeroes
 * - "," Use locale-specific grouping separators (i.e., the comma in 123,456)
 * - "(" Enclose negative numbers in parentheses
 * 
 * width - minimalna ilosc znakow do wydrukowania
 * 
 * precission - ilosc drukowanych miejsc po przecinku (dla zmiennoprzecinkowych)
 * 
 */
public class Format {
	static public void main(String[] args) {
		new Format().examples();
	}

	void examples() {

		System.out.printf("%2$d %1$d \n", 10, 20);

		// java.util.MissingFormatArgumentException
		// nie istnieje argument o numerze 2 
		/*
		System.out.printf("%2$d", 10); */

		int i1 = -123;
		int i2 = 12345;
		System.out.printf(">%1$(7d< \n", i1);
		System.out.printf(">%0,7d< \n", i2);
		System.out.format(">%+-7d< \n", i2);
		System.out.printf(">%2$b + %1$5d< \n", i1, false);
		
		/* java.util.IllegalFormatConversionException
		System.out.format("%d", 12.37); */
		
		System.out.format("%.1f", 12.35); // zaokragla w gore /-> 12.4
	}
}
