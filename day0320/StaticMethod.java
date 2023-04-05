package day0320;

public class StaticMethod {
	int n;


	void f1(int x) {
		n = x;
	}

	void f2(int x) {
		m = x;
	}

	static int m;

	// static 메소드 는 non-static 필드 및 메소드 사용 불가.
//	static void s1(int x) {
//		n = x;
//	}
//
//	static void s2(int x) {
//		f1(3);
//	}

	static void s3(int x) {
		m = x;
	}

	static void s4(int x) {
		s3(3);
	}

}
