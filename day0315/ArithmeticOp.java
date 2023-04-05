package day0315;

import java.util.Scanner;

public class ArithmeticOp {
	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		System.out.println("## 계산할 초는 ? ");
		
		int time = sc.nextInt();	
		int sec = time%60;
		int min = (time/60)%60;
		int hour = (time/60)/60;
		
		System.out.printf("시간은 ==> %d 시간\n분은   ==> %d 분\n초는   ==> %d 초",hour,min,sec);
		sc.close();
		
	}
}
