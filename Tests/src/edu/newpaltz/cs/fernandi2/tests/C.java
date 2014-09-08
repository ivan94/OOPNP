package edu.newpaltz.cs.fernandi2.tests;

public class C extends A implements B, B2{
	public static void main(String[] args) {
		
	}
}


class A{
	public void foo(){}
}

interface B{
	public void foo();
}
interface B2{
	public void foo();
}
