package day0327;

public class CallStackTest {
	public static void main(String[] args) {
		System.out.println("mian start");
		
		firstMethod();
		System.out.println("main end");
		
	}
	
	 static void firstMethod() {
		System.out.println("firstMethod start");
		secondMethod();
		System.out.println("firstMethod end");
		
	}
	static void secondMethod() {
		System.out.println("secondMethod start");
		System.out.println("secondMethod end");
		
	}
}
