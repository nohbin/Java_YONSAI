package day0315;

public class BitYou {
	public static void main(String[] args) {

		byte a = 'A', b;
		byte mask = 0x0F; //0000 1111 (2진수)
		System.out.printf("%X & %X = %X \n",a,mask,a&mask); // 논리 곱
		System.out.printf("%X | %X = %X \n",a,mask,a|mask); // 논리 합

		mask = 'a'-'A';
		
		b = (byte)(a^mask);
		System.out.printf("%c ^ %d = %c \n",a,mask,b);
		a=(byte)(b^mask);
		System.out.printf("%c ^ %d = %c \n",b,mask,a);
		
	}
}
