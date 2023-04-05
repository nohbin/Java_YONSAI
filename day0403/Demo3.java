package day0403;

import java.util.Arrays;
import java.util.Comparator;

class Descending implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2)*-1;
			
		}
		return -1;
	}

	
	
}

public class Demo3 {
	public static void main(String[] args) {

		String [] arr = {
				"tiger","lion","dog","cat"
		};
		
		Arrays.sort(arr, new Descending());
		System.out.println(Arrays.toString(arr));
		
 				 
		
	}
}
