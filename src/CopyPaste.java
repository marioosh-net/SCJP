interface I {}
public class CopyPaste {

	public static void main(String[] args) {
	    Integer a = 126;
	    Integer b = a;
	    a--;	// tutaj tak naprawde jest unboxing, odjecie na prymitywach i utworzneie nowego obiektu, dlatego
	    		// b sobie wskazuje na inny obiekt, a na inny, nowy.
	    System.out.println((a));
	    System.out.println((b));
	    
	    System.out.println((a == b));

	    
	    Integer c = 126;
	    Integer d = 126;
	    System.out.println((c == d));
	    Integer e = 1260;
	    Integer f = 1260;
	    System.out.println((e == f));
		
	}

	
	
}

class MM {
	static String name = "test";

	static MM getMM() {
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getMM().name);
	}
}