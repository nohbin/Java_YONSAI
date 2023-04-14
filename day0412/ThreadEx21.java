package day0412;

public class ThreadEx21 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public synchronized void withdraw(int m) {
		if (balance < m) {
			try {
				wait();
			} catch (Exception e) {
			}
			balance -= m;
		}
	}

	public synchronized void deposit(int m) {
		balance += m;
		notify();
	}
}

class RunnableEx21 implements Runnable {
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		Account ac = new Account();
		while (ac.getBalance() > 0) {
			int m = (int) (Math.random() * 3 + 1) * 100;
			ac.withdraw(m);
			ac.deposit(m);
			System.out.println("balance : " + ac.getBalance());
		}
	}

}
