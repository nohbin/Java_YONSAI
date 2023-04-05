package day0315;

import java.util.Scanner;

public class Sample01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 계산할 값을 입력하세요 ==> : ");
		double a = sc.nextDouble();		
		System.out.println("두번째 계산할 값을 입력하세요 ==> : ");
		double b = sc.nextDouble();
		System.out.printf("%.2f + %.2f = %.2f\n", a,b,a+b);
		System.out.printf("%.2f - %.2f = %.2f\n", a,b,a-b);
		System.out.printf("%.2f * %.2f = %.2f\n", a,b,a*b);
		System.out.printf("%.2f / %.2f = %.2f\n", a,b,a/b);
		System.out.printf("%d %% %d = %d", (int)a,(int)b,(int)a%b);
		sc.close();
		
	}
}
