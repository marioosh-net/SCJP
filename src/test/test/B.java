package test.test;

import java.util.Collection;

import test.test.test.*;

public class B extends A
{
   public static void main(String[] args)
   {
	   int[] a = {1,2};
	   try {
		   a[f()]++;
	   } catch (Exception e) {
		   System.out.println(a[0]);
		   System.out.println("name:john;;sex:m;;".split(";"));
		   for(String s: "name:john;;sex:m;;".split(";")) {
			   System.out.println(s);
		   }
		   
		   assert 10 > 10: null;
	   }
	   
   }
   
   static int f() throws Exception {
	   throw new Exception();
   }
   
   
}

abstract class TestClass1
{
	abstract protected void m1();

}
class sdsds extends TestClass1 {
	@Override
	 void m1() {
		// TODO Auto-generated method stub
		
	}
}
