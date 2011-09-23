package test1;

public class TryMe {
	Integer A;
	int a;

	public TryMe(int a) {
		this.a = A + a;		// java.lang.NullPointerException
		System.out.print(this.a);
	}

	public static void main(String args[]) {
		Integer A = new Integer(1);
		TryMe t = new TryMe(A);
	}
}