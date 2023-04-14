package day0407;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

class Student {
	String name;
	int grade;
	int ban;

	public Student(String name, int grade, int ban) {
		super();
		this.name = name;
		this.grade = grade;
		this.ban = ban;
	}

	@Override
	public String toString() {
		return "Student [name = " + name + ", grade = " + grade + ", ban = " + ban + "]";
	}

	
}

public class GenericEx2 {
	public static void main(String[] args) {
		List<Student> lists = new ArrayList<>();
		if(lists.add(new Student("성노빈", 3, 3)) == true) {
			System.out.println("입력 완료");
		}
		
		lists.add(new Student("홍길동", 2, 3));
		lists.add(new Student("김지수", 3, 3));
		Iterator<Student> i2 = lists.iterator();
		while (i2.hasNext()) {
			Student s =i2.next();
			System.out.println(s.name);
		}
		
		for (Student s : lists) {
			System.out.println(s.name);
		}
		
		 Predicate<String> startsWithCatsbi = (s) -> s.startsWith("catsbi");
	        Predicate<Integer> isOdd = (i) -> i%2 == 0;

	        System.out.println(startsWithCatsbi.test("catsbiStudyCode"));
	        System.out.println(isOdd.test(3));
	        System.out.println(isOdd.test(4));
	        
	        Predicate<Integer> isOdd2 = (i) -> i%2 == 0;
	        Predicate<Integer> isEven = (i) -> i%2 == 1;

	        System.out.println(isOdd2.and(isEven).test(4));
	        System.out.println(isOdd2.or(isEven).test(4));
	        System.out.println(isOdd2.negate().test(3));
		
		
	}
}
