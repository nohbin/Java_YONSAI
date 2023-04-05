package day0328;

public class TimeDemo {
	public static void main(String[] args) {

		Time t= new Time(12, 35, 30);
		System.out.println(t);
		t.setHour(t.getHour()+1);
		System.out.println(t);
		
	}
}
