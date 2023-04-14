package day0408;

import java.io.*;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		String str = "D:\\nohbin\\sample\\aaa.txt";
		FileInputStream fin = new FileInputStream(str);
		InputStreamReader in = new InputStreamReader(fin,"MS949");
		System.out.println("인코딩 문자 집합은 " + in.getEncoding());
		int c;
		while ((c = in.read()) != -1) {
			System.out.print((char)c);
		}
		in.close();
		
		InputStream is = new InputStream() {
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
	}
}
