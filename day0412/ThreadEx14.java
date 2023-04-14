package day0412;

import javax.swing.JOptionPane;

public class ThreadEx14 {
	public static void main(String[] args) {
		ThreadEx14_1 t1 = new ThreadEx14_1();
		t1.start();
		String input = JOptionPane.showInputDialog("아무값이나 입력 : ");
		System.out.println("입력값은 : " +input + " 입니다.");
		t1.interrupt();
		System.out.println("main.isInterupted()"+t1.isInterrupted());
		System.out.println("<<main end>>");
	}
}

class ThreadEx14_1 extends Thread {
	public void run() {
		int i = 10;
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("카운트 종료");
	}
}
