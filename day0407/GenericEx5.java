package day0407;

import java.util.ArrayList;
import java.util.List;

class Fruit implements Eatable {

	@Override
	public String toString() {
		return "Fruit []";
	}

}

class Orange extends Fruit implements Eatable{

	@Override
	public String toString() {
		return "Orange []";
	}

}

class Apple extends Fruit implements Eatable{

	@Override
	public String toString() {
		return "Apple []";
	}

}
class FruitBox<T extends Fruit & Eatable> extends Box<T>{
	
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

class Toy {

	@Override
	public String toString() {
		return "Toy []";
	}

}

interface Eatable {

}

public class GenericEx5 {
	public static void main(String[] args) {
		FruitBox<Fruit> fBox = new FruitBox<Fruit>();
		FruitBox<Fruit> aBox = new FruitBox<Fruit>();
		FruitBox<Fruit> oBox = new FruitBox<Fruit>();
		fBox.add(new Fruit());
		fBox.add(new Apple());
		fBox.add(new Orange());
		fBox.add(new Fruit());
		aBox.add(new Apple());
		oBox.add(new Orange());
		oBox.add(new Orange());

		System.out.println(fBox);
		System.out.println(aBox);
		System.out.println(oBox);
		
		
		
	}
}
