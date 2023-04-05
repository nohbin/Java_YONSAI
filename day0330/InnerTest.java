package day0330;

class InnerEx11 {
	class InstanceInner {
		int iv = 100;
//		static int cv = 100;
		final static int CONST = 100;
	}

	static class StaticI {
		int iv = 200;
		static int cv = 200;
	}

	void myMethod() {
		class LocalInner {
			int iv = 300;
//			static int cv = 300;
			final static int CONST = 300;
		}
		LocalInner li = new LocalInner();
	}

}

public class InnerTest {
	public static void main(String[] args) {
		System.out.println(InnerEx11.InstanceInner.CONST);
		System.out.println(InnerEx11.StaticI.cv);
		InnerEx11 i = new InnerEx11();
		i.myMethod();
		
	}
}
