package test1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Other {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale l = Locale.getDefault();
		DateFormat df = DateFormat.getInstance();
		Date d = new Date();
		System.out.println(l.getDisplayCountry() + " " + df.format(d));
	}

}
