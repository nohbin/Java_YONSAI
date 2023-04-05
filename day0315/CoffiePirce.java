package day0315;

import java.util.Scanner;

public class CoffiePirce {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	int price=0;
	System.out.println("주문을 입력하세요. (에스프레소 , 카푸치노 , 카페라떼 , 아메리카노)");
	String order = sc.next();
	switch (order) {
	case "에스프레소":
	case "카푸치노":
	case "카페라떼":
		price = 3500;
		break;
	case "아메리카노":
		price = 2000;
	default:
		System.out.println("메뉴에 없는 주문 입니다.");
	}
	if(price!=0) {
		System.out.println(order + " 는 " + price + " 원 입니다. ");
	}
	sc.close();
	
}
}
