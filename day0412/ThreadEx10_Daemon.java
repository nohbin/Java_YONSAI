package day0412;

public class ThreadEx10_Daemon implements Runnable {
	private static boolean autoSave = false;

	public static void main(String[] args) {
		
		Runnable r = new ThreadEx10_Daemon();
		Thread t1 = new Thread(r);
		t1.start();
		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			if(i==10) {
				autoSave = true;
			}
		}
		System.out.println("Main end");
		
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("파일이 자동저장되었습니다.");
	}

}
