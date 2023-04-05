package day0315;

class TrueFalse {

	public static void main(String[] args) {
		
	
	int x =5;
//	int y= 5;
	System.out.println((5<=3)&&(++x == 6)); // 조건 문 앞이 거짓일 시 뒷 문장 실행 X
	System.out.println(x);
	System.out.println((5<=3)&(++x == 6)); // 조건문 앞이 거짓이라도 뒷 문장 실행 O
	System.out.println(x);
	
	}
}
