package day0320;

public class ArrayEx3 {

	public static int[] makeArray() {
		int[] temp = new int[4];
		return temp;
	}
	
	public static void main(String[] args) {
	
		int []arr;
		arr = makeArray();
		System.out.println(arr.length);
		
		int[]a = new int[1];
		a[0] = 50;
		int b = a[0];
		a[0]=a[0]+10;
		System.out.println(b);
		System.out.println(a[0]);
		b=a[0];
		System.out.println(b);
	}
}
