package day0412;

import java.util.ArrayList;
import java.util.List;

class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	private List<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		if (dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dished : " + dishes.toString());
	}

	public synchronized boolean remove(String dishName) {
		while (dishes.size() == 0) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " 가 기다리는중");
			try {
				wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		while (true) {
			for (int i = 0; i < dishes.size(); i++) {
				if (dishName.equals(dishes.get(i))){
					dishes.remove(i);
					notify();
					return true;
				}
			}
			
		}
	}

	public int dishNum() {
		return dishNames.length;
	}
}

class Cook implements Runnable {
	private Table table;

	public Cook(Table table) {
		// TODO Auto-generated constructor stub
		this.table = table;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;

	public Customer(Table table, String food) {
		super();
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			String name = Thread.currentThread().getName();
			if (eatFood()) {
				System.out.println(name + " ate a " + food);
			} else {
				System.out.println(name + " fialed to eat. :( ");
			}
		}
	}

	private boolean eatFood() {
		// TODO Auto-generated method stub
		return table.remove(food);
	}

}

public class ThreadEx22 {
	public static void main(String[] args) throws InterruptedException {
		Table tabe = new Table();
		new Thread(new Cook(tabe), "COOK1").start();
		new Thread(new Customer(tabe, "donut"), "customer1").start();
		new Thread(new Customer(tabe, "burger"), "customer2").start();
		Thread.sleep(10000);
		System.exit(0);
	}
}
