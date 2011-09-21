package ch3;

/**
 * java.lang.StackOverflowError
 */
public class InitializationBlocks2 {
	static long i = 0;
	{
		i++;
		try {
			InitializationBlocks2 a = new InitializationBlocks2();
		} finally {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		new InitializationBlocks2();
	}
}
