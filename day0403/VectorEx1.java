package day0403;

import java.util.Vector;

public class VectorEx1 {
	public static void print(Vector v) {
		System.out.println(v);
		System.out.println(v.size());
		System.out.println(v.capacity());
	}
	public static void main(String[] args) {
		
		Vector v = new Vector(5);
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize();
		System.out.println("===trimToSize()===");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("===ensureCapacity(6)===");
		print(v);
		
		v.setSize(7);
		System.out.println("===setSize(7)===");
		print(v);
		
		v.clear();
		System.out.println("===v.clear()===");
		print(v);
		
	}
}
