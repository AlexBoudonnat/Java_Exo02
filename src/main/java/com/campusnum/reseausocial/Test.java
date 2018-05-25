package com.campusnum.reseausocial;

public class Test {
	
	
	public Test() {
		
		int j = 20, i = 0;
		try {
			System.out.println(j/i);
			
		} catch (ArithmeticException e) {
			System.out.println("Division par zero impossible !!!"+ e.getMessage());
		}
		System.out.println("coucou toi !");
		
	}

	public static void main(String[] args) {
		Test test = new Test();
	}

}
