package day0403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		List list = new ArrayList(length/LIMIT + 10);
		
		for (int i = 0; i < length; i+=LIMIT) {
			if(i+LIMIT < length) {
				list.add(source.substring(i,i+LIMIT));
			}else{
				list.add(source.substring(i));
			}
			
		}
		System.out.println(list.size());
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
		System.out.println(list);
		
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		list1.add(6);
		System.out.println(list1);
		
	}
}
