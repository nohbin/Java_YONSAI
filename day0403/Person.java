package day0403;

public class Person {

	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " : " + age;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (name + age).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}
		Person tmp = (Person) obj;

		return name.equals(tmp.name) && age == tmp.age;
	}

}
