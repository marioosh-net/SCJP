package ch10_development;

import java.util.Properties;
import java.lang.Object;

public class _Properties {
	public static void main(String[] args) {
		new _Properties().system();
	}
	
	public _Properties() {
		super();
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
