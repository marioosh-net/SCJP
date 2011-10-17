package ch6;

import java.util.Arrays;

public class Console1 {
	static String[] sa = { "a", "aa", "aaa", "aaaa" };
	static {
		Arrays.sort(sa);
	}

	   public static void main(String[] args)
	   {
	      Super s1 = new Super(); //1
	      Sub s2 = new Sub();     //2
	      s1 = (Super) s2;        //3
	   }

}

class Super {  }
class Sub extends Super {  }
class TestClassa
{

}
