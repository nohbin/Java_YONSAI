package day0404;

import java.util.TreeSet;

public class TreeSetEx2 {
	public static void main(String[] args) {

		TreeSet<String> ts = new TreeSet<>();
	
		String s1 = "b";
		String s2 = "d";
		ts.add("abc"); ts.add("alian"); ts.add("bat");
		ts.add("car"); ts.add("Car"); ts.add("cat");
		ts.add("dance"); ts.add("dasdg"); ts.add("dZZZ");ts.add("dzzz");
		ts.add("elephant"); ts.add("elevater"); ts.add("fan");ts.add("flow");
		
		System.out.println(ts);
		System.out.println("== b~d 까지 ==");
		System.out.println("ts.subSet() : " + ts.subSet(s1, s2));
		System.out.println("ts.subSet() : " +ts.subSet(s1, true, s2, true));
		
		
	}
}
