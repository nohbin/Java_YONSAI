package day0327;
public class ReferenceParamEx2 {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 5, 6, 4 ,10,9,7,8};
		int []a = new int[10];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)((Math.random()*100)+1);
		}
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		
		
//		int sum = sum(arr);
//		System.out.println(sum);
		System.out.println();
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		
	}

	static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}else {
					break;
				}
			}System.out.println(a[i]);
		}
	}
}
