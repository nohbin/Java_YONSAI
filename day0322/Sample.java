package day0322;

import java.util.ArrayList;

public class Sample implements Runnable {
	int seq;

	public Sample(int seq) {
		this.seq = seq;
	}

	@Override
	public void run() {
		System.out.println(this.seq + " 쓰레드 시작");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println(this.seq + " 쓰레드 끝");
	}
	
	int max(int a, int b) {
		return ((a>b)? a:b);
		
	}

	public static void main(String[] args) {

		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Sample(i));
			t.start();
			threads.add(t);
		}
		for (int i = 0; i < threads.size(); i++) {
			Thread t = threads.get(i);
			try {
				t.join();
			} catch (Exception e) {
			}

		}

		System.out.println("mian 끝.");

	}
}