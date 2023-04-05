package day0404;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx1 {
	public static void main(String[] args) {
		Map map = new HashMap();
		
		map.put("myId", 1);
		map.put("asdf", 2);
		map.put("qwer", 3);
		map.put("asdf", 4);
		Scanner sc= new Scanner(System.in);
		while (true) {
			System.out.println("아이디는 ? 패스워드는 ?");
			String id= sc.next();
			String pw = sc.next();
			if(!map.containsKey(id)) {
				System.out.println("다시 입력하세요");
				continue;
			}else {
				if(!(map.get(id).equals(pw))) {
					System.out.println("다시 입력하세요");
				}else {
					System.out.println("맞습니다");
					break;
				}
			}
		

		}
}
}