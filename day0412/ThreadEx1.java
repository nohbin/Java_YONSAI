package day0412;

class ThreadEx1_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <5; i++) {
			System.out.print("-");
			System.out.println();
		}
	}
}

class ThreadEx1_2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print("|");
			System.out.println();
		}
	}
}

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		System.out.println("main end");
	}
}
