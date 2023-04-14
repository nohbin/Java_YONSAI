package day0412;

public class ThreadEx5 {
	public static void main(String[] args) {
		ThreadEx5_1 t1 = new ThreadEx5_1();
		long startTime = System.currentTimeMillis();

		t1.start();
		for (int i = 0; i < 500; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println();
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}
class ThreadEx5_1 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println();
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}


