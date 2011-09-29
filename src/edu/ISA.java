package edu;

interface I1 {
}
interface I2 {
}

class C1 implements I1 {
}

class C2 implements I2 {
}

class C3 extends C1 implements I2 {
}

interface A {}
interface B {}
class D {}
class E {}

public class ISA {
	public static void main(String[] args) {
		C1 o1 = null;
		C2 o2 = null;
		C3 o3 = null;
		
		I1 i1 = o3; 
		I2 i2 = (I2) i1;
		
		B b = null;
		A a = (A)b;
		D d = null;
		E e = (E)d;
	}

}
