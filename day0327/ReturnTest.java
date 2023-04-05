package day0327;

public class ReturnTest {
	public static void main(String[] args) {
		int [] a = new int[2];
		ReturnTest rt = new ReturnTest();
		rt.add(3, 2, a);
		System.out.println(a[1]);
	
	}
	int add(int a, int b) {
		return a+b;
	}
	void add(int a,int b,int[] result) {
		result[1] = a+b;
	}
}
