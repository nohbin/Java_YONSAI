package day0320;

public class Circle {

	int radius;
	String name;
	
	public Circle() {}
	
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}


	public double getArea() {
		return 3.14*radius*radius;
	
		
	
	}
	
	public static void main(String[] args) {
		Circle c = new Circle(10);
		Circle c2 = c;
		
		System.out.println(c.getArea());
		System.out.println(c2.getArea());
		
		System.out.println(c.getArea());
	}
}
