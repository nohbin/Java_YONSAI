package day0403;

import java.util.Arrays;
import java.util.Comparator;

class Descomp implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		if (!(o1 instanceof Integer)) {
			return -1;
		}
		if (!(o2 instanceof Integer)) {
			return -1;
		}
		Integer i = (Integer) o1;
		Integer i2 = (Integer) o2;
		return i.compareTo(i2) * -1;
	}
}

public class ComparatorEx1 {
	public static void main(String[] args) {
		Integer[] arr = { 30, 50, 10, 40, 20 };
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new Descomp());
		System.out.println(Arrays.toString(arr));
	}
}
