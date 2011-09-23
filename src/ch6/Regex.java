package ch6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * 
 * ZASADY:
 * 
 * 1. In general, a regex search runs from left to right, and once a source's
 * character has been used in a match, it cannot be reused.
 * 
 * 2. metaznaki:
 * \d A digit
 * \s A whitespace character
 * \w A word character (letters, digits, or "_" (underscore))
 * . - dot (joker) any character
 * 
 * 3. kwalifikatory
 * ? is greedy, ?? is reluctant, for zero or once
 * * is greedy, *? is reluctant, for zero or more
 * + is greedy, +? is reluctant, for one or more
 * 
 */
public class Regex {
	private int exampleNumber = 0;

	static public void main(String[] args) {
		new Regex().test();
		
		System.out.println("=====================");
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("aabaababab");
		while(m.find()) {
			System.out.println(m.start() + ":" + m.group());
		}
		
	}

	void test() {
		String a = "abababa";
		String expr = "aba";
		searchIndexs(a, expr); // -> 0 4; indeksu 2 nie bedzie zgodnie z zasada nr 1

		// find digits
		a = "a12c3e456f"; /*
							expr = "\d";	// Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ ) */
		expr = "\\d";
		searchIndexs(a, expr);

		a = "ala ma koteczka";
		expr = "[ac]z"; // [ac] = a lub c
		searchIndexs(a, expr);

		a = "ala ma koteczka";
		expr = "[a-e]"; // zakres: [a-e] = a do e
		searchIndexs(a, expr); // 0 2 5 10 11 14 

		a = "cafeBABE";
		expr = "[a-cA-C]"; // polaczenie zakresow a-c i A-C - znak ma byc z jednego lub z 2-ego zakresu  
		searchIndexs(a, expr); // 0 1 4 5 6

		a = "cafeBABE";
		expr = "[^a-cA-C]"; // negacja zakresu(-ow) ^ <- not on exam!:)  
		searchIndexs(a, expr); // 2 3 7

		a = "0x 0x1 0xA";
		expr = "0[xX][0-9a-fA-F]"; // hex
		searchIndexs(a, expr); // 3 7

		// one or more = +
		a = "1 a12 234b";
		expr = "\\d+";
		searchIndexs(a, expr); // 0 3 6

		// (...)+ - kwalifikator + bedzie dzialal tylko dla wyrazenia w nawiasach
		a = "0x1243 0xafghh 0x44 0X2";
		expr = "0[xX]([0-9a-fA-F])+";
		searchIndexs(a, expr);

		// * - zero or more occurances
		// ? - zero or one occurance
		a = "proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java";
		expr = "proj1([^,])*";
		searchIndexs(a, expr);

		// . - jakikolwiek character
		a = "ac abc a c";
		expr = "a.c";
		searchIndexs(a, expr); // 3 7

		// greedy * (zachlanny)
		// greedy bierze pod uwage caly lancuch i szuka mozliwie 
		// najdluzszego dopasowania (siegajacego najdalej na prawo)
		a = "yyxxxyxx";
		expr = ".*xx";
		searchIndexs(a, expr); // 0 - cale wyrazenie

		// reluctant *? (leniwy, niechetny)
		a = "yyxxxyxx";
		expr = ".*?xx";
		searchIndexs(a, expr); // 0 4

		searchIndexs("aba", "a?"); // zero-length matches!

		// Scanner
		System.out.println("---------- Scanner " + ++exampleNumber + "----------");
		Scanner s = new Scanner("1b2c335f456");
		String token;
		do {
			token = s.findInLine("\\d\\d");
			System.out.println("found " + token);
		} while (token != null);

	}

	void searchIndexs(String source, String expr) {
		// java.util.regex.Matcher
		// java.util.regex.Pattern 

		// find() - zwraca true jesli znajdzie kolejne dopasowanie
		// group() - zwraca pasujacy fragment zrodlowego tekstu
		// start() - zwraca indeks startowy pasujacego fragmenu w zrodle
		// end() - zwraca indeks koncowy pasujacego fragmenu w zrodle

		System.out.println("---------- Example " + ++exampleNumber
				+ "----------");
		Pattern p = Pattern.compile(expr); // the expression
		Matcher m = p.matcher(source); // the source
		System.out.println("source: " + source);
		System.out.println("expr. : " + expr);
		while (m.find()) {
			System.out.print(m.start() + "-" + m.end() + ": [" + m.group()
					+ "], ");
		}
		System.out.println("");
	}
}
