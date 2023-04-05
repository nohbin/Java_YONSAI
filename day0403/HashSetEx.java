package day0403;


public class HashSetEx {
	public static void main(String[] args) {

		Person p1 = new Person("성노빈",32);
		
		int hashCode1 = p1.hashCode();
		int hashCode2 = p1.hashCode();
		
		p1.age = 20;
		
		int hashCode3 = p1.hashCode();
		
		System.out.println(hashCode1);
		System.out.println(hashCode2);
		System.out.println(hashCode3);
		
		p1 = new Person("성노빈",32);
		Person p2 = new Person("성노빈", 32);
		
		boolean b = p1.equals(p2);
		hashCode1 = p1.hashCode();
		hashCode2 = p2.hashCode();
		
		
		System.out.println(b);
		System.out.println(hashCode1);
		System.out.println(hashCode2);
		
		
	}
}
