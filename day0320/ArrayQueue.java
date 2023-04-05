package day0320;
import java.util.Scanner;

public class ArrayQueue {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[] queue = new char[5];
		int rear = 0;

		char carName = 'A';
		int select = 0;

		while (select != 3) {
			System.out.print("<1> 자동차 넣기 <2>자동차 빼기 <3> 끝 \n");
			select = sc.nextInt();
			switch (select) {
			case 1:
				if (rear == 5) {
					System.out.println("터널이 꽉 차서 못들어감");

				} else {
					if (rear <5) {
						queue[rear] = carName++;
						System.out.print("현재 자동차 ==> ");
						for (char c : queue) {
							System.out.print(c + " ");
						}
						System.out.println();
						rear++;
					} else {
						System.out.println("더 이상 자동차가 없습니다.");
					}
				}
				break;

			case 2:
				if (rear <= 0) {
					System.out.println("빠져나갈 자동차가 없음");
				} else {
					for (int i = 0; i < 4; i++) {
						queue[i] = queue[i + 1];
						queue[i+1] = ' ';
					}
					System.out.print("현재 자동차 ==> ");
					for (char c : queue) {
						System.out.print(c + " ");
					}
					System.out.println();
					rear--;
				}

				break;
			case 3:
				System.out.printf("현재 터널에 %d대가 있음\n", rear);
				System.out.printf("프로그램 종료");

				break;

			default:
				System.out.println("다시 입력하세요.");
				break;
			}

		}

	}
}
