package day0403;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		List ll = new LinkedList<>();
		System.out.println("= 순차적 으로 추가하기 =");
		System.out.println("ArrayList : " + add1(al));
		System.out.println("LinkedList : " + add1(ll));
		System.out.println();
		System.out.println("= 중간에 추가하기 =");
		System.out.println("ArrayList : " + add2(al));
		System.out.println("LinkedList : " + add2(ll));
		System.out.println();
		System.out.println("= 중간에서 삭제하기 =");
		System.out.println("ArrayList : " + remove2(al));
		System.out.println("LinkedList : " + remove2(ll));
		System.out.println();
		System.out.println("= 순차적 으로 삭제하기 =");
		System.out.println("ArrayList : " + remove1(al));
		System.out.println("LinkedList : " + remove1(ll));
		
	}
	public static long add1(List l) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			l.add(i+"");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long add2(List l) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			l.add(500,"X");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long remove1(List l) {
		long start = System.currentTimeMillis();
		for (int i = l.size()-1; i >= 0; i--) {
			l.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long remove2(List l) {
		long start = System.currentTimeMillis();
		for (int i = 0; i <10000; i++) {
			l.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
}
