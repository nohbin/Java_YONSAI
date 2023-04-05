package day0315;

import java.util.Scanner;

public class GetCoin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		System.out.println("교환할 금액은 : " + value);
		
		int coin_500 = value / 500;
		value = value%500;
		int coin_100 = value /100;
		value = value%100;
		int coin_50 = value / 50;
		value = value%50;
		int coin_10 = value / 10;
		value = value%10;
		
		System.out.printf("5백원 : %d\n백원 : %d\n오십원 : %d\n십원 : %d\n나머지 : %d",coin_500,coin_100,coin_50,coin_10,value);
		sc.close();
		
		
	}
	
}
