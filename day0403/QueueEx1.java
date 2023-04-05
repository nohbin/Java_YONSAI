package day0403;

import java.util.*;


public class QueueEx1 {
	static Queue q = new LinkedList<>();
	static final int MAX_SIZE = 5;
	public static void save(String input) {
		if(!"".equals(input)) {
			q.offer(input);
		}
		if(q.size() > MAX_SIZE) {
			q.remove();
		}
	}
	public static void main(String[] args) {
		System.out.println("help 를 입력하시면 도움말을 볼수 있습니다.");
		while(true) {
			System.out.print(">>");
			try {
				Scanner sc= new Scanner(System.in);
				String input = sc.nextLine().trim();
				if("".equals(input)) {
					continue;
				}
				if(input.equals("q")) {
					System.exit(0);
				}else if(input.equalsIgnoreCase("help")) {
					System.out.println("help - 도움말");
					System.out.println("q 또는 Q - 프로그램 종료");
					System.out.println("history - 최근입력 명령어");
				}else if(input.equalsIgnoreCase("history")) {
					int i = 0;
					save(input);
					List tmp = (List) q;
					Iterator it = tmp.listIterator();
					while(it.hasNext()) {
						System.out.println(++i + "."+it.next());
					}
				}else {
					save(input);
					System.out.println(input);
				}
				
				
			} catch (Exception e) {
				System.out.println("입력 오류 입니다.");
			}
		}
		
		
	}
}
