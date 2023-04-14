package day0412;

import javax.swing.JOptionPane;


class ThreadEx7_1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


public class ThreadEx7 {
	public static void main(String[] args) {
		ThreadEx7_1 t = new ThreadEx7_1();
		t.start();
		String input = JOptionPane.showInputDialog("임의의 값을 입력하세요");
		System.out.println("입력하신 값은 : "+input+" 입니다");
		
	}
}
