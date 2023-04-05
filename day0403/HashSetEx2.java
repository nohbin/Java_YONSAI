package day0403;

import java.util.*;


public class HashSetEx2 {
	public static void main(String[] args) {

		Object[] objarr = {"1",1,"2","2","3","3","4","4","4"};
		Set<Object> set = new HashSet<>();
		for (int i = 0; i < objarr.length; i++) {
			set.add(objarr[i]);
		}
		for (Object o : objarr) {
			System.out.print(o+" ");
		}
		System.out.println();
		List<Object> ls = Arrays.asList(objarr);
		ls.forEach(x->System.out.print(x + " "));
		System.out.println();
		System.out.println(set);
		
	}
}
