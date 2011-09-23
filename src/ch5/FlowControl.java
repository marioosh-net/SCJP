package ch5;

public class FlowControl {

	void test() {
		// zle
		if(true) 
			String s = "a";
		
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
	}
	
	void x() {};
}
