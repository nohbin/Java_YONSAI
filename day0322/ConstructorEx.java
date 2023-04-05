package day0322;

class A {
	public A() {
		System.out.println("생성자 A ");
	}
}

class B extends A {
	public B() {
		System.out.println("생성자 B ");

	}
	public B(int a) {
		System.out.println("b1");
	}
	

}

class C extends B {
	public C() {
		super();
		System.out.println("생성자 C ");
	}
	public C(int a) {
		super(a);
		System.out.println("생성자 c1");
	}

}

public class ConstructorEx {

	public static void main(String[] args) {
		C c = new C();
		C c1 = new C(1);
		

	}

}
