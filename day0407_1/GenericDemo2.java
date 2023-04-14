package day0407_1;

class Box1<T> {
	T item;

	void setItem(T t) {
		this.item = t;
	}

	T getItem() {
		return this.item;
	}
}

public class GenericDemo2 {
	public static void main(String[] args) {

		Box1<String>b = new Box1<>();
		b.setItem("abc");
		String item = b.getItem();
		System.out.println(item);
		
	}
}
