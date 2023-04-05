package day0315;

import java.util.Scanner;

public class aaaa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i <n; i++) {
			for (int j = n; j >= i; j--) {
				System.out.print(" ");
			}
			for (int a = 0; a < i * 2 + 1; a++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		for (int i = 1; i <n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int a = n*2+1; a >= i * 2 + 1; a--) {
				System.out.print("*");
			}
			System.out.println();

		}
		
		
//		for (int i = 0; i <= 3; i++) {
//			for (int j = 3; j >= i; j--) {
//				System.out.print(" ");
//			}
//			for (int a = 0; a <= i * 2 + 2; a++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	
	}
}
