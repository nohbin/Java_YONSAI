package day0315;

import java.util.Scanner;

/*
 * 사칙연산 입력
 * 0 으로 나누기 시 0으로 나눌수 없습니다. 입력
 * 
 */
public class Demo2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("연산 >> ex ( 1 + 1)");
		int x = sc.nextInt();
		String a = sc.next();
		int y = sc.nextInt();
		

		if (a.equals("+")) {
			System.out.printf("%d + %d = %d", x, y, x + y);
		} else if (a.equals("-")) {
			System.out.printf("%d - %d = %d", x, y, x - y);
		} else if (a.equals("*")) {
			System.out.printf("%d * %d = %d", x, y, x * y);
		} else if (a.equals("/")) {
			if (x == 0 || y == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
			} else {
				System.out.printf("%d / %d = %d", x, y, x / y);
			}
		}
		
		switch (a) {
		case "+":
			System.out.printf("%d + %d = %d", x, y, x + y);
			break;
		case "-":
			System.out.printf("%d - %d = %d", x, y, x - y);
			break;
		case "*":
			System.out.printf("%d * %d = %d", x, y, x * y);
			break;
		case "/":
			if (x == 0 || y == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			} else {
			System.out.printf("%d / %d = %d", x, y, x / y);
			}
			break;

		default:
			break;
		}
		
		sc.close();

	}
}
