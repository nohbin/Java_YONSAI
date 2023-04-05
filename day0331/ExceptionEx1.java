package day0331;

public class ExceptionEx1 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main()에서 예외처리함");
			e.printStackTrace();
		}
	}
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1()에서 예외처리함");
			throw e;
		}
	}
}
