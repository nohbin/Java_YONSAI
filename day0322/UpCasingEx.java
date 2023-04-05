package day0322;

class Person_1{
	String name;
	String id;
	
	
	
	public Person_1(String name) {
		this.name = name;
	}

	public void eat(String menu) {
		System.out.println(menu+ "를 주문");
	}
	
	public void run(Student_1 p1) {
		System.out.println(p1.name);
		p1.eat("랍스터");
	}
}

class Student_1 extends Person_1{
	public Student_1(String name) {
		super(name);
	}
	 int grade;
	 String department;
	public void study(int hour) {
		System.out.println("오늘 공부한 시간 : " + hour);
	}
	
}

public class UpCasingEx {
	public static void main(String[] args) {
		Person_1 p1 = new Student_1("성노빈");
		Student_1 s1 = (Student_1)p1;
		
		s1.run(s1);
		s1.grade = 5;
		s1.department = "사회학"
				+ " 과에 다니는"
				+ " 너는 누구냐"
				+ " 나는 성노빈"
				+ "이다.";
		s1.eat("콜라");
		p1.eat("환타");
		s1.study(5);
		System.out.println(s1.department);
		
		
		
		
		
		
		
		
	}

}
