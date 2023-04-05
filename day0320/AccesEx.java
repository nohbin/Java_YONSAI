package day0320;

class Simple{
	public int a;
	private int b;
	static int a1;
	int c;
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
}

public class AccesEx {

	public static void main(String[] args) {
		Simple s = new Simple();
		Simple s1 = new Simple();
		
		s.a = 10;
		s.setB(15);
		s.getB();
		s.c = 10;
		Simple.a1 = 10;
		s.a1 = 11;
		s1.a1 = 12;
		
		System.out.println(Simple.a1);
		
		
		
	}
	
}
