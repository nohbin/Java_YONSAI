package day0315;

import java.util.Scanner;

public class Grading {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("점수를 입력하세요(0~100) : ");
		int s = sc.nextInt(); // 점수 읽기
		
		System.out.println("학년을 입력하세요(1~4) :");
		int y = sc.nextInt();
				

		if(s >= 60) {
			if(y !=4) {
				System.out.println("합격");				
			}else if(s >= 70) {
				System.out.println("합격");
			}else {
				System.out.println("불합격!");
			}		
		}else {
			System.out.println("불합격!");
		}
		sc.close();
		
	}
}
