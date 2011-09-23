package ch6;

import java.util.Scanner;

/**
 * 
 * Tokenizing
 * - wejscie: duze kawalki danych;
 * - wyjscie: male kawalki danych umieszczone w zmiennych
 * 
 * np.
 * token;token;token... (; - delimiter)
 * TOKENIZE(token1;token2;token3...) -> TOKENS: token1, token2, token3
 * 
 * Metody:
 * 1. String.split() - do prostych zdan
 * 2. java.util.Scanner - najlepszy jako tokenizer
 * - tokenizing w petli (moze byc przerwany)
 * - zrodlem moze byc strem, string, files
 * - tokeny moga byc konwetowane do odpwiednich typow
 * 
 */
public class Tokenizing {
	private int exampleNumber;

	static public void main(String[] args) {
		new Tokenizing().test();
		new Tokenizing().scanner();
	}

	void test() {
		// delimiterem jest srednik
		String source = "token1;token2;token3";
		String regex = ";";
		split(source, regex);

		// delimiterem jest cyfra
		source = "asd2da3das3dasqew";
		regex = "\\d";
		split(source, regex);

		source = "a.bbb.cc.d";
		regex = "\\.";
		split(source, regex);
	}

	void split(String source, String regex) {
		System.out.println("---------- Example " + ++exampleNumber
				+ "----------");
		// String.split(regex)
		// zwraca talice tokenow, ktore oddziela wyrazenie pasujace do wyrazenia reglarnego (regex)
		String[] tokens = source.split(regex);
		for (String token : tokens) {
			System.out.println(token);
		}
	}

	// Scanner - Best Of Tokenizer :)
	void scanner() {
		System.out.println("---------- Scanner" + ++exampleNumber
				+ "----------");

		String source = "asdqw  easd casa";
		Scanner s1 = new Scanner(source);
		// hasNext() - testuje wartosc kolejnego tokena, ale go nie pobiera
		// next() - pobiera kolejny token
		// domyslnie bialy znak jest delimiterem
		while (s1.hasNext()) {
			System.out.println(s1.next());
		}

		System.out.println("---------- Scanner" + ++exampleNumber
				+ "----------");

		// hasNextXxx() - dla wszystkich primitives oprocz chara
		// nextXxx() - pobiera kolejny prymitywny token
		Scanner s2 = new Scanner("1 true 34 hi");
		boolean b;
		while (b = s2.hasNext()) {
			if (s2.hasNextInt()) {
				int i = s2.nextInt();
				System.out.println("integer token: " + i);
			} else if (s2.hasNextBoolean()) {
				boolean b2 = s2.nextBoolean();
				System.out.println("boolean token: " + b2);
			} else {
				String str = s2.next();
				System.out.println("String token: " + str);
			}
		}

		System.out.println("---------- Scanner" + ++exampleNumber
				+ "----------");

		// useDelimiter(delimiter) - ustawienie delimitera (wyrazenia regularnego) wg ktorego bedzie przetwarzany strumien
		// domyslnym delimiterem jest spacja, tabulator, ogolnie bialy znak lub znaki
		Scanner s3 = new Scanner("Test1 true 34 hi");
		s3.useDelimiter("\\d"); // delimiterem jest cyfra
		while (s3.hasNext()) {
			System.out.println(s3.next());
		}
	}

}
