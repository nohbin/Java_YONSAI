package day0315;

public class StringExcute {
	public static void main(String[] args) {
		
		String name = "JDK";
		name += 1.8;
		System.out.println(name + "은 최고야!");
			
		char a = 'A';
		char b = '글';
		char c = '\u0041'; // 문자 'A'의 유니코드 값(0041) 사용
		char d = '\uae00'; // 문자 '글'의 유니코드 값(ae00) 사용
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}
