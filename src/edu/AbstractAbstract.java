package edu;

abstract class Calculator
{
	abstract void calculate();
	public static void main(String[] args)
	{
		System.out.println("calculating");
		Calculator x = null;
		x.calculate();
	}
}

