package day0403;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEx {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		Iterator<Integer> it = list.iterator();

		while (it.hasNext()) {
			list2.add(it.next());
			it.remove();
		}
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
		
	}
}
