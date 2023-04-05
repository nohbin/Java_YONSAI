package day0404;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo {
	public static void main(String[] args) {

		List<Student> st = new ArrayList<>();
		st.add(new Student("a", 80));
		st.add(new Student("b", 70));
		st.add(new Student("c", 50));
		st.add(new Student("d", 90));
		st.add(new Student("e", 100));

		// 리스트에 들어있는 학생 데이터를 점수가 높은 순으로.정렬 해주세요
		System.out.println(st);
		st.sort(null);
		System.out.println(st);
		
		// 이름순으로 출력해주세요,.
		st.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return (o1.name.compareTo(o2.name));
			}
		});

		System.out.println(st);

		
	}
}
