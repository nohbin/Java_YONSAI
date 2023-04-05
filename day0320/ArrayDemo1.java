package day0320;
import java.util.Scanner;

public class ArrayDemo1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double[] arr = new double[4];
		int i = 0;
		double sum = 0.0;
		double mul = 1.0;
		while (i<4) {
			
			System.out.print(i+1+"번째 숫자를 입력하세요 : ");
			arr[i] = sc.nextDouble();
			sum += arr[i];
			mul *= arr[i];
			i++;
			
		}
		System.out.println("합계 ==> " + sum);
		System.out.println("곱셈 ==> " + mul);
		
		
	
		
	}
}
