package day0412;

class ThreadEx2_1 extends Thread {

	@Override
	public void run() {
		System.out.println("run");
		throwException();
	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("exception");
		}
	}

}

public class ThreadEx2 {
	public static void main(String[] args)  {
		ThreadEx2_1 t = new ThreadEx2_1();
		System.out.println("main");
		t.start();
	}
}
