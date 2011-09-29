package ch6;

public class Console {
	public static void main(String[] args) {
		java.io.Console console = System.console();
		
		// czyta linie z konsoli
		String s = console.readLine();
		
		// czyta haslo z konsoli (zwraca char[], nie String !!!)
		char[] pw = console.readPassword("%s", "password: ");
		
	}
}
