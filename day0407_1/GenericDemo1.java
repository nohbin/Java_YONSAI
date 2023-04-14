package day0407_1;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	@Override
	public String toString() {
		return "Fruit []";
	}
}
class Orange extends Fruit {
	@Override
	public String toString() {
		return "Orange []";
	}
}
class Apple extends Fruit {
	@Override
	public String toString() {
		return "Apple []";
	}
}
class FruitBox<T extends Fruit> extends Box<T>{
}
class Box<T>{
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
		return "Box = " + list.toString();
	}
}
public class GenericDemo1 {
	public static void main(String[] args) {
		Box box = null;
		Box<Object> objBox = null;
		box = (Box<Object>)objBox;
		objBox = (Box<Object>) box;
		
		Box<?> wBox = new Box<String>();
		objBox = (Box<Object>) wBox;
		objBox.add("123");
		
		
		
		
		
	}

}
