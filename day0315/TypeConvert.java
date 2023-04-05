package day0315;

public class TypeConvert {
	public static void main(String[] args) {

		int n = 300;
		byte b1 = (byte)n;
		byte b2 = 127;
		int i = 100;
		
		System.out.println(b1);
		System.out.println(b2+i);
		System.out.println(10/4.0);
		System.out.println(0123); // 8진법
		System.out.println(0x23); // 16진법
		System.out.println(0b1011); // 2진법
		System.out.println((byte)(b2+i));
		System.out.println((char)0x0041); // default 값이 int 형으로 char 2byte 로 나머지 앞에 문자를 제거		
		System.out.println(2.9+1.8f); 
		System.out.println(2.9f+1.8); 
		
		
		
	}
}
