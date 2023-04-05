package day0331;

public class StringBufferEx1 {
	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());
		sb.append(01);
		StringBuffer sb2 = sb.append(23);
		sb.append(4).append(56);
		
		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0);
		
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3);
		
		System.out.println(sb.deleteCharAt(10));
		System.out.println(sb.delete(3, 6));
		System.out.println(sb.capacity());
		System.out.println(sb.insert(3, "abc"));
		System.out.println(sb.capacity());
		System.out.println(sb.replace(6, sb.length(), "end"));
		System.out.println(sb.capacity());
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		
	}
}
