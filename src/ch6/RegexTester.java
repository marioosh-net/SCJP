package ch6;

import java.util.regex.*;

public class RegexTester {
	public static void main(String[] args) {
		if (args.length > 1) {
			Pattern p = Pattern.compile(args[0]);
			Matcher m = p.matcher(args[1]);
			System.out.println("Pattern is " + m.pattern());
			while (m.find()) {
				System.out.println(m.start() + " " + m.group());
			}
		}
	}
}