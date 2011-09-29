package ch1;

public class Constructors4 {
	// public static void main(String args) {	// java.lang.NoSuchMethodError: main
	// public static void main(String[] args) {	// OK
	public static void main(String... args) {	// OK
		System.out.println(args.length);
		new I();
		
		Type first = new SubType(); //line 16
		System.out.println(first.getTypeName()); //line 17		
	}
}

class K {
	public K() {
		System.out.println("member K");
	}
}

class I {
	K i = new K();

	I() {
		System.out.println("konstruktor I");
	}
}

class Type {
	public Object getTypeName(){
		return "Type";
	}
}

class SubType extends Type {
	public String getTypeName(){//line 8
		return "SubType";
	}
}

