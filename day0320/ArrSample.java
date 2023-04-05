package day0320;
import java.util.Scanner;

public class ArrSample {
	public static void main(String[] args) {
		

		int[] arr = new int[5];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Scanner(System.in).nextInt();
			if (arr[i] > max) max = arr[i];	
		}
		System.out.printf("가장 큰 수는 %d 입니다.\n",max);
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
		}
		System.out.printf("평균은 %d / %d = %.2f",sum,arr.length,(double)sum/arr.length);
	
	for (int i = 0; i < arr.length; i++) {
		int j = arr[i];
		
	}
	
	}
}
