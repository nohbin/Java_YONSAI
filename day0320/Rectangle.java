package day0320;

import java.util.Scanner;

public class Rectangle {

	int widht;
	int height;
	
	public int getArea() {
		return widht*height;
	}
	
	public static void main(String[] args) {

		Rectangle r = new Rectangle();
		Scanner sc = new Scanner(System.in);
		r.widht = sc.nextInt();
		r.height = sc.nextInt();
		
		System.out.println(r.getArea());
				
		
	}
}
