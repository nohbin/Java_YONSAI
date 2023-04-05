package day0315;

/*
 * for 문 3번씩 돌리는 문장.
 * 
 */

public class Gugudan {
	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j += 3) {
				System.out.print(j + " * " + i + " = " + j * i + "\t");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 1; i < 10; i++) {
			for (int j = 3; j < 10; j += 3) {
				System.out.print(j + " * " + i + " = " + j * i + "\t");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 1; i < 10; i++) {
			for (int j = 4; j < 10; j += 3) {
				System.out.print(j + " * " + i + " = " + j * i + "\t");
			}
			System.out.println();
		}
		
		

	}
}
