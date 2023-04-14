package day0412;

import javax.swing.JOptionPane;

public class ThreadEx13 {
	public static void main(String[] args) {
		ThreadEx13_1 t1 = new ThreadEx13_1();
		t1.start();
		System.out.println("isInterupted()"+t1.isInterrupted());
		String input = JOptionPane.showInputDialog("아무값이나 입력 : ");
		System.out.println("입력값은 : " +input + " 입니다.");
		t1.interrupt();
		System.out.println("main.isInterupted()"+t1.isInterrupted());
		System.out.println("main.interupted()"+t1.interrupted());
		System.out.println("<<main end>>");
	}
}

class ThreadEx13_1 extends Thread {
	public void run() {
		int i = 10;
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for (long j = 0; j < 2500000000L; j++) {

			}
		}
		System.out.println("t1.isInterrupted() " + this.isInterrupted());
		System.out.println("t1.interrupted() " + Thread.interrupted());
	}
}
