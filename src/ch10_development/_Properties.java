package ch10_development;

import java.util.Properties;

public class _Properties {
	public static void main(String[] args) {
		new _Properties().system();
	}
	
	void system() {
		/**
		 * Using System Properties
		 */		
		Properties p = System.getProperties();
		p.setProperty("myProp", "myValue");
		p.list(System.out);
	}
}
