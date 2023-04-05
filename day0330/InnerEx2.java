package day0330;
class ex{
	static class ex1{
		static int a= 100;
	}
}

public class InnerEx2 {
	Integer num1 = 10;
	static Integer num2 = 10;
	void print() {
		SInner s1 = new SInner();
		int a=SInner.sinnerNum;
	}
	class Inner{
		int innerNum = 100;
		int b1 = 10;
	}
	static class SInner{
		
		static int sinnerNum = 500;
	}
	public static void main(String[] args) {
		ex e= new ex();
//		ex1 ex1 = e.new
		int bb = SInner.sinnerNum;
		Integer a = InnerEx2.num2;
		
		InnerEx2 outer = new InnerEx2();
		Integer mainNum = outer.num1;
		
		InnerEx2.Inner inner1 = outer.new Inner();
		InnerEx2.Inner inner2 = outer.new Inner();
		int innernum = inner1.innerNum;
		
		SInner si1 = new SInner();
		SInner si2 = new SInner();
		System.out.println(SInner.sinnerNum);
		
		System.out.println(si1);
		System.out.println(si2);
	}
}
