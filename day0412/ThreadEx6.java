package day0412;

import javax.swing.JOptionPane;

public class ThreadEx6 {
	public static void main(String[] args) throws InterruptedException {
		String input = JOptionPane.showInputDialog("임의의 값을 입력하세요");
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println("입력하신 값은 : "+input+" 입니다");
	}
}
