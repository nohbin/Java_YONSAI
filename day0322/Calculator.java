package day0322;

public abstract class Calculator {
	public abstract int add(int a,int b);
	public abstract int subtract(int a, int b);
	public abstract double average(int[] a);
	
	public static void main(String[] args) {
		GoodCalc gc = new GoodCalc();
		int sum = gc.add(10, 20);
		int sub = gc.subtract(10, 20);
		int[] avg1 = {10,20,30,40,50};
		int avg = (int) gc.average(avg1);
		
		System.out.println(sum + " " + sub + " " + avg);
	}
	
	
	
}

class GoodCalc extends Calculator{
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double average(int[] a) {
		double avg = 0.0;
		
		for (int i = 0; i < a.length; i++) {
			avg += a[i];
		}
		avg /= a.length;
		return avg;
	}
	
}