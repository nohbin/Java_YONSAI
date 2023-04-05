package day0331;

import java.util.StringJoiner;

public class StringJoinerEx {
	

	public static void main(String[] args) {

		String animals = "dog,cat,bear";
		String []arr = animals.split(",");
		String str = String.join("-", arr);
		System.out.println(str);
		
		StringJoiner sj = new StringJoiner(":", "[", "]");
		sj.add("George").add("Sung").add("nohbin");
		String desiredString = sj.toString();
		System.out.println(desiredString);
		
		int i = Integer.parseInt("123");
		int i1 = Integer.valueOf("123");
		
		System.out.println(i+i1);
		
		
		
	}
}
