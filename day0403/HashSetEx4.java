package day0403;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx4 {
	public static void main(String[] args) {

		Set<Object> setA = new HashSet<>();
		Set<Object> setB = new HashSet<>();
		
		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");
		System.out.println("A : " +setA);
		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		System.out.println("B : "+setB);
		
		Set<Object> setHab = new HashSet<>();
		Set<Object> setKyo = new HashSet<>();
		Set<Object> setCha = new HashSet<>();
		
		Iterator<Object> it = setA.iterator();
		while (it.hasNext()) {
			setHab.add(it.next());
		}
		it = setB.iterator();
		while (it.hasNext()) {
			setHab.add(it.next());
		}
		System.out.println("setHab : " +setHab);
		
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setB.contains(tmp)) {
				setKyo.add(tmp);
			}
		}	
		System.out.println("setKyo : " +setKyo);
		
		it = setA.iterator();
		while (it.hasNext()) {
			Object tmp = it.next();
			if(!(setB.contains(tmp))) {
				setCha.add(tmp);
			}
		}
		System.out.println("setCha : " +setCha);
		
		
	}
}
