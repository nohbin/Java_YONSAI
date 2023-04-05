package day0322;

abstract class Shape1 { // 추상 클래스 선언
	public Shape1() { }
	public void paint() { 
		draw(); 
		}
	abstract public void draw(); // 추상 메소드
}

abstract class MyComponent { // 추상 클래스 선언
	String name;
	public void load(String name) {
		this.name = name;
	}
} 

class Circle1 extends Shape1{

	@Override
	public void draw() {
		System.out.println("Circle");
		
	}
	
}


public class AbstractEx01 {

	public static void main(String[] args) {
		
	}
	
}
