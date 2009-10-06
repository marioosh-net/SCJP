package ch6;

/**
 * 
 * format string:
 * %[arg_index$][flags][width][.precision]conversionChar
 * gdzie [] - opcjonalne;
 * conversionChar:
 * - b boolean
 * - c char
 * - d integer
 * - f floating point
 * - s string
 * 
 */
public class Format {
	static public void main(String[] args) {
		new Format().examples();
	}

	void examples() {

		System.out.printf("%2$d %1$d", 10, 20);

		// java.util.MissingFormatArgumentException
		// nie istnieje argument o numerze 2
		System.out.printf("%2$d", 10);
	}
}
