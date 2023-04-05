package day0330;

import java.util.Scanner;

class ExceptionA extends Exception {

	void methodA() {
		System.out.println("ExceptionA`s method");
	}

	public ExceptionA(String a) {
		super(a);
	}

}

class ExceptionB extends Exception {
	void methodB() {
		System.out.println("ExceptionB`s method");
	}

	public ExceptionB(String a) {
		super(a);
	}
}

public class ExceoptionEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String i = sc.next();
		try {
			if(i.equals("true")) {
			ExceptionA e= new ExceptionA("exceptionA");
			throw e;
			}
			else {
				ExceptionB eb = new ExceptionB("exceptionB");
				throw eb;
			}
		} catch (ExceptionA | ExceptionB e) {
			if(e instanceof ExceptionA) {
				ExceptionA ea = (ExceptionA)e;
				ea.methodA();
			}else {
				ExceptionB eb = (ExceptionB)e;
				eb.methodB();
			}
				
		}
	}
}
