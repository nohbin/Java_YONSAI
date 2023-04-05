package day0322;

public class Student extends Person {

	static int diff(char a, char b) {
		return b-a;
	}
	
	
	
	public Student() {
		System.out.println("hello");
	}

	public void set() {
		age = 30;
		name = "성노빈";
		height = 175;
		setWeight(99);
	}
	
	public void setAge(int a) {
		this.age = a;
	}
	
	public static void main(String[] args) {
		System.out.println(diff('R', 'E')); 
		
	}

}
