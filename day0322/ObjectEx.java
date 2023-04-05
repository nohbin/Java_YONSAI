package day0322;

class Point1{
	private int x,y;
	public Point1(int x , int y) {
		this.x = x;
		this.y = y;
	}
}

public class ObjectEx {
	public static void print(Object obj) {
		System.out.println("get class() : " +obj.getClass());
		System.out.println("get class().get name() : " +obj.getClass().getName());
		System.out.println("get hashcode() : "+obj.hashCode());
		System.out.println("get toString() : " + obj.toString());
		System.out.println(obj);
		
	}
	public static void main(String[] args) {
		Point1 p = new Point1(2, 3);
		Point1 a = new Point1(2, 3);
		Point1 b = new Point1(2, 3);
		Point1 c = a;
		
		
	}
}
