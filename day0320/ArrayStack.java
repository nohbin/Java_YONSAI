package day0320;
import java.util.Scanner;

public class ArrayStack {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char[]stack = new char[5];
		int top = 0;
		
		char carName = 'A';
		int select = 0;

		while (select != 3) {
			System.out.println("<1> 자동차 넣기 <2> 자동차 빼기 <3> 끝");
			select = sc.nextInt();
			
			
			
			if(select == 1) {
				stack[top] = carName++;
				System.out.printf("%c 자동차가 터널에들어감 \n", stack[top]);
				top++;
				if (top == 5) {
					System.out.println("터널이 꽉 차서 차가 못들어감");
					continue;
				}
			}else if(select == 2) {
				top--;
				System.out.printf("%c 자동차가 터널에서 빠짐 \n",stack[top]);
				stack[top]= ' ';
				if(top == 0) {
					System.out.println("터널에 차가 없음");
					continue;
					}
			}
			
			
			
		}
		
	}
}
