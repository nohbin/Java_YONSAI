package day0404;

import java.util.TreeSet;

public class TreeSetEx1 {
	public static void main(String[] args) {

		TreeSet<Integer> ts = new TreeSet<>();
		int[]score = {80,75,92,50,45,100,10,65,35};
		for (int i = 0; i < score.length; i++) {
			ts.add(score[i]);
		}
		System.out.println("50보다 작은 값. : " + ts.headSet(50));
		System.out.println("50보다 큰 값. : " + ts.tailSet(50));
		
		
	}
}
