package ch5;

public class FlowControl {

	public static void main(String[] args) {
		/* zle
		if(true) 
			String s = "a"; */
		
		// ok
		if(true) {
			String s = "a";
		}
		
		// ok
		if(true);
		
		// ok
		if(true)
		if(true)
			x();
		else x();
		
		/**
		 * UWAGA
		 */
		Boolean b = null;
		if(b) {	}	// NullPointerException
		
	}
	
	static void x(){}

}
