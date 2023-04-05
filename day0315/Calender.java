package day0315;

import java.util.Scanner;

public class Calender {
	
	public static void lunarYear () {
		
		Scanner sc = new Scanner(System.in);	
		int year = sc.nextInt();
		String strYear = (year%4==0 && year%100!=0 || year%400==0) ? " 년은 윤년입니다." : " 년은 윤년이 아닙니다."; 
		System.out.printf("%d%s",year,strYear);
		
	}
	public static void main(String[] args) {
		
		

		
		
		
		
	}
}
