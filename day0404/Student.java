package day0404;

public class Student implements Comparable<Student> {
	public String name;
	public int jumsu;
	
	public Student(String name, int jumsu) {
		this.name = name;
		this.jumsu = jumsu;
				
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", jumsu=" + jumsu + "]\n";
	}
	@Override
	public int compareTo(Student o) {
		
		return this.jumsu - o.jumsu;
	}

}
