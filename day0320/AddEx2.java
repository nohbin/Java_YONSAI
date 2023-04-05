package day0320;

import java.lang.invoke.VolatileCallSite;

class AddArr{
	int[]num = new int[6];
	public void setNum() {
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)((Math.random()*45)+1);
			
		}
	}
	
	
	public int sumNum(int[]num) {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i]; 
		}
		return sum;
	}
}

public class AddEx2 {
	public static void main(String[] args) {
		
		
		
		AddArr a = new AddArr();
		
		a.setNum();
		for (int data : a.num) {
			System.out.print(data + " ");
		}
		System.out.println();
	System.out.println(a.sumNum(a.num));	
		
	}

}
