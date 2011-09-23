package test1;

public class Loop {

	public static void main(String[] args) {

		int i = 10;
		while (++i <= 10) {
			System.out.println("while");
			i++;
		}
		System.out.print(i);
		
		i = 10;
		while (i++ <= 10) {
			System.out.println("while");
			i++;
		}
		System.out.println(i);
	}

}
