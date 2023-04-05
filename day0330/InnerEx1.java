package day0330;

class Outer{
	int num = 1;
	String name = "good name";
	
	void methodOuter() {
		System.out.println("outer method!!");
	}
	class Inner{
		void pirnt() {
			System.out.println("name : " + name);
			System.out.println("몸무게" + weight);
		}
		double height= 10.0;
		double weight = 11.1;
		String state = "good state";
	}
}

public class InnerEx1 {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner oi = o.new Inner();
		oi.pirnt();
	}
}
