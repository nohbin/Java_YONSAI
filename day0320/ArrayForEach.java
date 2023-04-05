package day0320;

public class ArrayForEach {
	enum Week { 월, 화, 수, 목, 금, 토, 일 }
	
	public static void main(String[] args) {
		
		String str = new String();
		str = "abc";
		System.out.println(str.lastIndexOf(str)); 
		
		for (Week data : Week.values()) {
			System.out.print(data + " "); 	
		}
		
	}
}
