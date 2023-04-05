package day0315;

import java.util.Scanner;

public class FindCircle {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("처리 할 수를 입력하세요 : ");
		int n = sc.nextInt();
		
		if(n<0) System.out.println("입력한 수는 - 입니다.");
		else if(n==0) System.out.println("입력한 수는 0 입니다.");
		else System.out.println("입력한 수는 + 입니다.");
		

	}
}
