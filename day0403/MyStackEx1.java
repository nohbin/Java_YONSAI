package day0403;

import java.util.*;

class Mystack extends Vector {
	public Object push(Object o) {
		addElement(o);
		return o;
	}

	public Object pop() {
		Object o = peek();
		// Stack 에 저장된 마지막 요소를 읽어온다.
		// 만일 Stack 이 비어잇으면 peek() 메소드가 EmptyStackException 을 발생시킨다.
		// 마지막 요소를 삭제한다. 배열의 index 가 0부터 시작하므로 1을 빼준다
		removeElementAt(size() - 1);
		return o;
	}

	public Object peek() {
		int len = size();
		if (len == 0) {
			throw new EmptyStackException();
		}
		// 마지막 요소를 반환한다. 배열의index 가 0부터 시작하므로 -1 해준다.
		return elementAt(len - 1);
	}

	public boolean empty() {
		return size() == 0;
	}

	public int search(Object o) {
		int i = lastIndexOf(o); // 끝에서 부터 객체를 찾는다.
		// 반환값은 저장된 위치(배열의 index)이다.
		if (i >= 0) { // 객체를 찾은 경우
			// Stack 은 맨 위에 저장된 객체의 index 를 1로 정희하기 때문에 계산을 통해서 구한다.
			return size() - 1;
		}
		return -1; // 해당 객체를찾지 못하면 -1을 반환한다.
	}
}

public class MyStackEx1 {
	public static void main(String[] args) {
		Mystack s = new Mystack();
		s.push("cat");
		s.push("lion");
		s.push("dog");
		s.push("zebra");

		while (!s.empty()) {
			if (s.search("dog") != -1) {
				System.out.println(s.pop());
			}
		}
	}
}
