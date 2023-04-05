package day0322;

public class StudentEx {
	public static void main(String[] args) {
		Student st = new Student();
		st.set();
		System.out.println(st.age);
		System.out.println(st.getWeight());
		System.out.println(st.name);

		Person p = new Student();

		boolean a = st instanceof Student;
		System.out.println(a);
		
	}
}
