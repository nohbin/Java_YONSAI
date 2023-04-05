package day0315;

public class GuguDanA4 {
	public static void main(String[] args) {

		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 10; j++) {
				for (int j2 =i*3-2 ; j2 < i*3+1; j2++) {
					System.out.print(j2 + " * " + j + " = " + j2 * j + "\t" );
				}System.out.println();
			}System.out.println();
		}
	}
}
