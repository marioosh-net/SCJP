package edu;

public class SuperSuper {
	static class A {  public void perform_work(){}  }
	 static class B extends A {  public void perform_work(){}  }
	 static class C extends B {  public void perform_work(){}
	 	void c() {
	 		super.perform_work();
	 	}
	 }

	 public static void main(String[] args) {
		C c = new C();
	}
}
