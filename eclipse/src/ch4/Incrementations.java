package ch4;

public class Incrementations {
	public static void main(String[] args) {
		int s = 7;
		
		s+=++s;
		System.out.println(s);
		
		/**
		 * postincrementacja
		 * s++ bedzie juz po przypisaniu (s = s + s);
		 */
		s = 7;
		s+=s++;
		System.out.println(s);
		
		/**
		 * podobnie jak wyzej s-- bedzie gubione
		 */
		s = 7;
		s-=-s--;
		System.out.println(s);		
		
		/**
		 * leci preincrementacja, ale postincrementacja moze tylko na wyrazeniu byc, 
		 * a tutaj juz bedzie wartosc zmiennej (++s -> zmienna), nie mozna robic 2++;
		 */
		s = 7;
		s+=++s++;	// Invalid argument to operation ++/--
		System.out.println(s);
	}
}
