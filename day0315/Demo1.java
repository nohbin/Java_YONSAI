package day0315;

import java.util.Scanner;

/*
 * 숫자를 입력받아 
 * 3~5 = 봄
 * 6~8 = 여름
 * 9~11 = 가을
 * 12~2 = 겨울
 * 그외는 잘못입력
 */

public class Demo1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("input number (1~12)");
		int n = sc.nextInt();

		if (n >= 3 && n <= 5)
			System.out.println("Spring");
		else if (n >= 6 && n <= 8)
			System.out.println("Summer");
		else if (n >= 9 && n <= 11)
			System.out.println("Fall");
		else if (n>=1&&n<=2 || n==12)
			System.out.println("Winter");
		else
			System.out.println("Wrong Number");

		switch (n) {
		case 1:
		case 2:
			System.out.println("Winter");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("Spring");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("Spring");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("Fall");
			break;
		case 12:
			System.out.println("Winter");
			break;
		default:
			System.out.println("Wrong number");
			break;
		}

	}
}
