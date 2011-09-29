package pulapki;

public class T1 {
	public static void main(String[] args) {
		class Horse {
			private String name;

			public Horse(String s) {
				name = s;
			}
		}
		Object obj = new Horse("Zippo");
		System.out.println(obj.name);
		
		Horse h = new Horse("Zippo");
		System.out.println(h.name);
	}
}

class A
{
}
class TestClass
{
	public class A
	{
		public void m() { }
	}
	class B extends A
	{
	}
	public static void main(String args[])
	{
		new TestClass().new A() { 	 public void m() { } };
	}
}