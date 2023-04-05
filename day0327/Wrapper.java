package day0327;

public class Wrapper {
	public static void main(String[] args) {
		System.out.println(Character.toLowerCase('A'));
		char c1 = '4',c2 = 'F';
		if(Character.isDigit(c1)) {
			System.out.println(c1 + " 는 숫자");
		}
		if(Character.isAlphabetic(c2)) {
			System.out.println(c2 + " 는 영문자");
		}
		
		System.out.println(Integer.parseInt("-123")); // -123 을 10진수로 변환
		System.out.println(Integer.toHexString(28));// 정수 28을 2진수로 변환
		System.out.println(Integer.toBinaryString(28)); // 28을 16진수 문자열로
		System.out.println(Integer.bitCount(28));// 28에 대한 2진수의 1의 개수
		
		Double d = Double.valueOf(3.14); // 상수값을 value of 로 double type 의 obj 로 바꿈
		System.out.println(d.toString());
		System.out.println(Double.parseDouble("3.14"));
		
		boolean b = (4>3); // b = true;
		System.out.println(Boolean.toString(b)); // true 를 문자열 "true 로"
		System.out.println(Boolean.parseBoolean("false")); //문자열"false"를 false 로
		
		
		
	}
}

	
