package day0327;

import java.util.Vector;

public class Demo {
	public static void main(String[] args) {

		String s= "123";
		String s2 = "456";
		
		Vector<String> s1 = new Vector<>();
		
		s1.add(s2);
		s1.add(s);
		s1.add(s2);
		s1.add(s2);
		 System.out.println( s1.firstElement());
		
		System.out.println(s1.isEmpty()); 
		
	}
}
