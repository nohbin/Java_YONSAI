package day0412;

class ThreadEx8_1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
			for (int j = 0; j < 100000; j++) {
				
			}
		}
	}
}
class ThreadEx8_2 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
			for (int j = 0; j < 1; j++) {
				
			}
		}
	}
}

public class ThreadEx8 {
	public static void main(String[] args) {
		ThreadEx8_1 t1 = new ThreadEx8_1();
		ThreadEx8_2 t2 = new ThreadEx8_2();
		t2.setPriority(10);
		t1.setPriority(1);
		System.out.println("priority of " +t1.getPriority());
		System.out.println("priority of " + t2.getPriority());
		t1.start();
		t2.start();
		
	}
}
