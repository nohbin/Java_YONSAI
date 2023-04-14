package day0407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Box3<T>{
	List<T> list = new ArrayList<>();
	void add(T t) {
		list.add(t);
	}
	T get(int i) {
		return list.get(i);
	}
	int size() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
}

public class GenericEx3 {
	public static void main(String[] args) {
		Box3 box = null;
		Box3<Object> objBox = null;
		box = (Box3)objBox;
		objBox = (Box3<Object>) box;
		
		Box3 <? extends Object> wBox = new Box3<String>();
		
		FruitBox<? extends Fruit> box2 = null;
		FruitBox<Apple> appleBox = (FruitBox<Apple>) box2;
		
		String s= "abc";
		Box3<?> w = new Box3<String>();
		Box3<String> boxs = (Box3<String>) w;
		boxs.add(s);
		System.out.println(boxs.get(0));
		
		String [] names = {"catsbi","aansol","mosition"};
		 Arrays.sort(names,(a,b)->a.compareTo(b));
		System.out.println(Arrays.toString(names));
		
		Integer[] arr = {10,4,11,23,2,12,5};
		Arrays.sort(arr,(a,b)->a.compareTo(b));
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
	}
}
