package day0407;

import java.util.ArrayList;
import java.util.List;

class Product{
	int price;
	String brand;
	public Product(int price, String brand) {
	
		this.price = price;
		this.brand = brand;
	}
	
}
class Tv extends Product{
	public Tv(int price, String brand ,int size) {
		super(price, brand);
		this.size = size;
	}

	int size;

	@Override
	public String toString() {
		return "Tv [size=" + size + ", price=" + price + ", brand=" + brand + "]";
	}
}
class Audio extends Product{
	public Audio(int price, String brand , int volume) {
		super(price, brand);
		this.volume = volume;
	}
	int volume;
	@Override
	public String toString() {
		return "Audio [volume=" + volume + ", price=" + price + ", brand=" + brand + "]";
	}
}

public class GenerixEx1 {
	public static void main(String[] args) {
		List<Product> lists = new ArrayList<>();
		List<Tv> tvLists = new ArrayList<>();
		List<Audio> audioLists = new ArrayList<>();
		lists.add(new Tv(1200000, "Lg", 70));
		lists.add(new Audio(100000, "Yamaha", 6));
		tvLists.add(new Tv(100000, "Saumsung", 70));
		audioLists.add(new Audio(1000000, "Shure", 6));
		
		printAll(lists);
		printAll(tvLists);
		printAll(audioLists);
	}
	public static <E> void printAll(List<E> lists) {
		for (E e : lists) {
			System.out.println(e);
		}
	}
}
