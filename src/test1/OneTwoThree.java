package test1;

public class OneTwoThree {

	public static void main(String args[]) {
		Object myObj = new String[] { "one", "two", "three" };
		{
			for (String s : (String[]) myObj)
				System.out.print(s + ".");
		}
	}
}
