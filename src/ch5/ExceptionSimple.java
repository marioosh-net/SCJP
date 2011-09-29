package ch5;

public class ExceptionSimple {
	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
			
		} finally {
			System.out.println("finally");
		}
		System.out.println("end");
	}
}
