package day0403;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionEx1 {
	public static void main(String[] args) {

		List<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(4);
		lists.add(2);
		lists.add(6);
		lists.add(9);
		lists.add(10);
		lists.add(8);
		lists.add(9);
		System.out.println(lists);
		Collections.shuffle(lists);
		System.out.println(lists);
		Collections.sort(lists);
		System.out.println(lists);
		System.out.println(lists.iterator());
	}
}
