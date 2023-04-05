package day0403;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx1 {
	

	public static void print(List l, List l2) {
		System.out.println("lists : " +l);
		System.out.println("lists2 : " +l2);
		System.out.println();
	}

	public static void main(String[] args) {

		List lists = new ArrayList(10);
		lists.add(5);
		lists.add(4);
		lists.add(2);
		lists.add(0);
		lists.add(1);
		lists.add(3);

		List lists2 = new ArrayList(lists.subList(1, 4));
		print(lists, lists2);
		Collections.sort(lists);
		Collections.sort(lists2);
		System.out.println("정렬 후");
		print(lists, lists2);
		System.out.println("lists.containsAll(lists2) : " + lists.containsAll(lists2));
		System.out.println();
		
		lists2.add("B");
		lists2.add("C");
		lists2.add(3, "A");
		System.out.println("lists.containsAll(lists2) : " + lists.containsAll(lists2));
		print(lists, lists2);

		lists2.set(3, "AA");
		print(lists, lists2);

		System.out.println("lists.retainAll(lists2) : " + lists.retainAll(lists2));
		print(lists, lists2);

		for (int i = lists2.size()-1; i >= 0; i--) {
			if (lists.contains(lists2.get(i))) {
				lists2.remove(i);
			}
		}
		print(lists, lists2);

	}
}
