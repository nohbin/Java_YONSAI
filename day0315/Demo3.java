package day0315;

import java.util.Scanner;

/*
 * 원의 정보를 받기 위해 키보드로부터 원의 중심을 나타내는 한 점과 반지름을 입력받는다.
 * 두 개의 원을 입력받고 두 원이 서로 겹치는지 판단하여 출력하라.
 * 
 * ex
 * 첫번째 원의 반지름 >> 10 10 3
 * 두번째 원의 반지름 >> 12 12 2
 * 두 원은 서로 겹친다.
 * 
 */
public class Demo3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 원의 중심과 반지름 입력 : ");
		double num = sc.nextDouble();
		double num1 = sc.nextDouble();
		double r = sc.nextDouble();

		System.out.print("두번째 원의 중심과 반지름 입력 : ");
		double i = sc.nextDouble();
		double j = sc.nextDouble();
		double r1 = sc.nextDouble();

		double call = Math.sqrt(((num - i) * (num - i)) + ((num1 - j) * (num1 - j)));

		if (call <= r + r1)
			System.out.print("두 원은 서로 겹친다.");
		else
			System.out.print("두 원은 서로 겹치지 않는다.");
		sc.close();

	}
}
