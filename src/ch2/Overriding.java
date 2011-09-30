package ch2;

import static java.lang.System.out;

public class Overriding {
	public static void main(String[] args) {
		out.println(new Sub().myMethod());
	}
}
interface Best {
	Object better();
	int primit();
	Integer obj();
}
class Base1 {
	public Object myMethod() { return null; }
}

class Sub extends Base1 implements Best {
	
	/**
	 * covariant return (subtype of Object)
	 * Integer jest subtypem Object, wiec jest overriding
	 */
	@Override
	public Integer myMethod() {	return null; }
	
	@Override
	public Best better() { return null; }
	
	@Override
	public int primit() { return 0;	}
	// public Integer primit() {return null;	}	// incompatibile return 
	@Override
	public Integer obj() {return null;	}
	// public int obj() {return 0;	}				// incompatibile return

}
