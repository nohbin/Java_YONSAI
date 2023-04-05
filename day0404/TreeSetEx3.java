package day0404;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
class TestComp implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}

class Test  implements Comparable{
	int x,y;

	@Override
	public int compareTo(Object o) {
		return 1;
	}
}

public class TreeSetEx3 {
	public static void main(String[] args) {
		
		Set set = new TreeSet(new TestComp());
		for (int i = 0; set.size() < 6; i++) {
			set.add(new Test());
			set.add(new Test());
			set.add(new Test());
			set.add(new Test());
			set.add(5);
		}
		System.out.println(set);
	}
}
