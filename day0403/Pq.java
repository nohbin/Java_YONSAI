package day0403;

import java.util.PriorityQueue;
import java.util.Queue;

public class Pq {
	public static void main(String[] args) {

		Queue pq = new PriorityQueue<>();
		pq.offer(3);
		System.out.println(pq);
		pq.offer(1);
		System.out.println(pq);
		pq.offer(5);
		System.out.println(pq);
		pq.offer(2);
		System.out.println(pq);
		pq.offer(4);
		System.out.println(pq);
		
		System.out.println(pq.peek());
		pq.remove();
		System.out.println(pq.peek());
		pq.remove();
		System.out.println(pq.peek());
		pq.remove();
		System.out.println(pq.peek());
		pq.remove();
		System.out.println(pq.peek());
		pq.remove();
		
		
	}
}
