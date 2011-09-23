package test1;

/**
 * 
 * java.lang.ExceptionInInitializerError
Caused by: java.lang.NullPointerException
	at test1.Block.<clinit>(Block.java:16)
Exception in thread "main" 
 *
 */
public class Block {

	static int x[];

	static {
		x[0] = 1;
	}

	public static void main(String args[]) {
	}

}
