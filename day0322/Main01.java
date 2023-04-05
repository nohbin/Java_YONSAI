package day0322;

import java.util.Scanner;

public class Main01 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]= sc.nextInt();
		}

		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			if(arr[j]%arr[j]==0) {
			count ++;
			}
			if(arr[j]==1) {
				count --;
			}
		}
		System.out.println(count);
		
		
				

	}
}
