package day0320;

import java.util.Arrays;

public class ArrParamEx {
public static void main(String[] args) {
	
	char c[] = {'T','h','i','s',' ','i','s',' ','a',' ','p','e','n','c','i','l','.'};
	String z = c.toString();
	System.out.println(z);
	String a = Arrays.toString(c);
	System.out.println(a);
	String d= a.substring(0, 1);
	System.out.println(d);
}
}
