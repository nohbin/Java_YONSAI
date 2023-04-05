package day0322;

public class ObjectClass {
public static void main(String[] args) {
	
	String s1 = "abcd";
	String s2 = new String("abcd");
	
	boolean a = s1.equals(s2);
	System.out.println(a);
	boolean b = s1 == s2;
	System.out.println(b);
	
}
}
