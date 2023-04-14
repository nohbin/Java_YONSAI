package day0407;

import java.util.ArrayList;
import java.util.List;
class Fruit2  {
	@Override
	public String toString() {
		return "Fruit";
	}
}
class Orange2 extends Fruit2 {

	@Override
	public String toString() {
		return "Orange";
	}
}
class Apple2 extends Fruit2 {
	@Override
	public String toString() {
		return "Apple";
	}
}
class Juice {
	String name;
	public Juice(String name) {
		this.name = name+" Juice!";
	}
	@Override
	public String toString() {
		return name ;
	}
}
class FruitBox2<T extends Fruit2> extends Box2<T>{
}
class Box2<T>{
	List<T> list = new ArrayList<>();
	List<T> getList(){
		return list;	
	}
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
class Blander<T>{
	static <T extends Fruit2> Juice makeJuice(FruitBox2<? extends Fruit2>f) {
		String tmp = "";
		for (Fruit2 name : f.getList()) {
			tmp = f.toString();
		}
		return new Juice(tmp);
	}
}
public class GenericEx6 {
	public static void main(String[] args) {
		FruitBox2<Fruit2> fbox  = new FruitBox2<>();
		fbox.add(new Apple2());
		fbox.add(new Orange2());
		fbox.add(new Apple2());
		System.out.println(Blander.makeJuice(fbox));
		System.out.println(Blander.<Fruit2>makeJuice(fbox));
	}
}
