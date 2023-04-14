package day0407;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Student2{
	String name;
	int grade;
	int ban;
	int kor;
	int eng;
	int math;
	



	public Student2(String name, int grade, int ban, int kor, int eng, int math) {
		super();
		this.name = name;
		this.grade = grade;
		this.ban = ban;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}




	@Override
	public String toString() {
		return "name=" + name + ", grade=" + grade + ", ban=" 
				+ ban + ", kor=" + kor + ", eng=" + eng
				+ ", math=" + math;
	}

	


	
	
}


public class MapEx3 {
	public static void main(String[] args) {
		
		Map<Integer, Student2> map = new HashMap<>();
		map.put(1, new Student2("성노빈", 6, 3, 99, 99, 100));
		map.put(2, new Student2("홍길동", 5, 3, 96, 91, 85));
		map.put(3, new Student2("성가연", 6, 3, 26, 30, 35));
		Iterator<Map<Integer, Student2>> it =Arrays.asList(map).iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
	}
}
