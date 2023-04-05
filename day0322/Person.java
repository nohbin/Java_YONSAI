package day0322;

import java.util.Objects;

public class Person {

	private int weight;
	int age;
	protected int height;
	public String name;

	public Person() {
		System.out.println("yo");
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, height, name, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Person other = (Person) obj;
		
		return age == other.age && height == other.height && 
				Objects.equals(name, other.name) && 
				weight == other.weight;
	}

	
	
	
	
//	public void setAge(int a) {
//		this.age = a;
//	}
	
	public static void main(String[] args) {
		
	}

}
