package ch6;

import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Working with Dates, Numbers, and Currencies
 */
public class DatesAndNumbers {
	static public void main(String[] args) {
		new DateClass().examples();
		new CalendarClass().examples();
		new DateFormatClass().examples();
		new LocaleClass().examples();
		new NumberFormatClass().examples();
	}
}

/**
 * klasa java.util.Date
 */
class DateClass {
	void examples() {
		System.out.println("------------------DateClass--------------");

		// standarowe pobranie biezacej daty
		Date now = new Date();
		System.out.println(now.toString());

		Date d = new Date();

		// ustawienie daty na podstawie liczby ms od 1970.01.01
		d = new Date(1400002222200L);
		System.out.println(d.toString());

		// setTime(), getTime()
		d.setTime(10000031231231l);
		System.out.println(d.toString());

		d.setTime(d.getTime() + 3600000); // 3600000 millis / hour
		System.out.println(d.toString());
	}
}

/**
 * klasa java.util.Calendar
 */
class CalendarClass {

	void examples() {
		System.out.println("------------------CalendarClass--------------");
		/*
		 * tak nie wolno! Calendar c = new Calendar(); Calendar[] cals = new
		 * Calendar[2]; // ale tak WOLNO!, bo to tylko tablica referencji
		 */// klasa abstrakcyjna!

		// factory - getting subclass of Calendar
		Calendar c = Calendar.getInstance();

		// setTime, set
		c.setTime(new Date());
		c.set(2010, 11, 14);

		// getTime() - zwraca postac daty
		Date d = c.getTime();

		// get(int field) - pol nie trzeba znac na exam!
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		if (c.getFirstDayOfWeek() == c.MONDAY) {
			System.out.println("Europe");
		}

		// add() - dodawania, odejmowanie czasu od daty
		System.out.println(c.getTime());
		c.add(Calendar.HOUR, 4); // dodanie 4 godzin
		System.out.println(c.getTime());
		c.add(Calendar.YEAR, -2); // odjecie 2 lat
		System.out.println(c.getTime());

		// roll() - dodawania/odejmowanie czasu, ALE nie zmieniajac wiekszych
		// jednostek
		c.setTimeInMillis(1400002222200L); // Tue May 13 19:30:22 CEST 2014
		System.out.println(c.getTime());
		c.roll(Calendar.MONTH, 9); // dodaje 9 miesiecy do maja - daje w efekcie
		// luty, ale rok zostaje ten sam!
		System.out.println(c.getTime()); // Thu Feb 13 19:30:22 CET 2014
	}
}

/**
 * 
 * java.text.DateFormat
 * 
 */
class DateFormatClass {
	void examples() {
		System.out.println("------------------DateFormatClass--------------");
		Date d = new Date();

		// formaty
		DateFormat df0 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat[] dfa = new DateFormat[6];
		dfa[0] = DateFormat.getInstance();
		dfa[1] = DateFormat.getDateInstance();
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT); // rozne style
		// formatowania
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);

		for (DateFormat df : dfa) {
			// format(Date) - utworzonym formatem formatujemy date biezaca
			System.out.println(df.format(d));
		}

		// parse(String) -> Date; ze sformatowanego Stringa robi Date
		String s = df0.format(d);
		System.out.println("s: " + s);
		try {
			Date d1 = df0.parse(s);
			System.out.println(d1.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Locale class
 */
class LocaleClass {
	void examples() {

		System.out.println("------------------LocaleClass--------------");
		// constructors
		Locale l_pl1 = new Locale("pl"); // ISO 639 Language Code
		Locale l_pl2 = new Locale("pl", "PL"); // + ISO Country Code
		Locale l_en = new Locale("en", "GB");
		Locale l_it = new Locale("it", "IT");
		Locale l_unsupported = new Locale("uk");
		
		// pobranie domyslnej lokalizacji
		Locale l = Locale.getDefault();
		System.out.println("Default locale: " + l.getDisplayName());

		// DateFormat i NumberFormat moga miec ustawione lokale TYLKO podczas
		// tworzenia (getInstance)
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, l_pl1);
		System.out.println(df.format(new Date())); // 2 paŸdziernik 2009

		df = DateFormat.getDateInstance(DateFormat.LONG, l_en);
		System.out.println(df.format(new Date())); // October 2, 2009

		df = DateFormat.getDateInstance(DateFormat.LONG, l_unsupported);
		System.out.println(df.format(new Date())); // 2 ?????? 2009

		// getDisplayCountry(), getDisplayCountry(Locale)
		String wlochyPoAngielsku = l_it.getDisplayCountry(l_en);
		String wlochyPoPolsku = l_it.getDisplayCountry(l_pl1);
		System.out.println(wlochyPoAngielsku);
		System.out.println(wlochyPoPolsku);

		// getDisplayLanguage()
		System.out.println(l_en.getDisplayLanguage()); // -> angielski
		System.out.println(l_en.getDisplayLanguage(l_en)); // -> English

		// Locale.setDefault() - ustawianie domyslnej lokalizacji
		Locale.setDefault(l_en);
	}
}

/**
 * 
 * ZASADY:
 * 	1. standardowy format (NumberFormat.getInstance()) ZAOKRAGLA w gore liczbe do 3 miejsc po przecinku
 */
class NumberFormatClass {
	void examples() {
		System.out.println("------------------NumberFormatClass--------------");

		// tworzenie przez getInstance...
		NumberFormat f = NumberFormat.getInstance();
		NumberFormat f1 = NumberFormat.getCurrencyInstance(new Locale("pl",
				"PL"));
		// domyslnie formatuje na 3 cyfry po przecinku i ZAOKRAGLA! -> 232.272
		String n = f.format(232.27183);	
		String n1 = f1.format(232);

		System.out.println(n);
		System.out.println(n1);

		// getMaximumFractionDigits() - zwraca maksymalna ilosc miejsc po
		// przecinku dla danego formatu
		// setMaximumFractionDigits() - ustawia powyzsze
		int max = f1.getMaximumFractionDigits();
		System.out.println("max fraction: " + max);
		System.out.println(f1.format(1234.222123));
		f1.setMaximumFractionDigits(5);
		System.out.println(f1.format(1234.222123));

		// setParseIntegerOnly() - ustala parsowanie tylko czesci bez przecinka 
		try {
			System.out.println(f.parse("42343.22"));	// -> 42343.22 
			f.setParseIntegerOnly(true);
			System.out.println(f.parse("42343.22"));	// -> 42343
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
