package day0315;

/*
 *         *
 *        * *
 *       * * *
 *      * * * *  
 *    
 *         *
 *        ***
 *       *****
 *      *******
 *     *********  
 *    
 *    
 */
public class PrintStar {
	public static void main(String[] args) {
		
		int a = 5;
		
		for (int i = 1; i <= a; i++) {
			for (int j = a; j >i ; j--) {
				System.out.print(" ");
			}
	
			for (int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		
		for (int i = 1; i <= a; i++) {
			
			for (int j = a; j >i ; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		
		for (int i = 0; i < a; i++) {
		
			for (int j = i; j < a-1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i*2+1; j++) {
					System.out.print("*");
				}			
			System.out.println("");
		}
		
		
		
		for (int i = a-1; i  > 0; i--) {
			for (int j = i; j < a; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (i*2)-1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
}
