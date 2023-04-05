package day0315;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {

		System.out.println("입력하세요 : 이름 , 생년월일 , 키 , 몸무게 , 주소 ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("이름은 : " + name);
		int birth = sc.nextInt();
		System.out.println("생일은 : " + birth);
//		int height = sc.nextInt();
//		System.out.println("키는 : " + height);
//		int weight = sc.nextInt();
//		System.out.println("몸무게는 : " + weight);
//		String address = sc.next();
//		System.out.println("주소는 : " + address);
		sc.close();
		System.out.printf("이름은 %s 이며 생일은 %d 입니다.",name,birth);
		
		
		
	}
}
