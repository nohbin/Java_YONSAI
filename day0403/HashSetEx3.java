package day0403;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx3 {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		
		set.add("abc");
		set.add("abc");
		set.add(new Person("성노빈", 32));
		set.add(new Person("성노빈", 32));
		
		System.out.println(set);
		
		
		
	}
}
