package day0331;

public class StringBufferEx {
	public static void main(String[] args) {

			StringBuffer sb = new StringBuffer();
			StringBuffer sb2 = sb;
			sb.append("123");
			sb2.append("123");
			System.out.println(sb==sb2);
			System.out.println(sb.equals(sb2));
			
		
	}
}
