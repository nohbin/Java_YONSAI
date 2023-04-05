package day0330;

import java.io.File;
import java.util.Scanner;

public class ExceptionEx4 {
	public static void main(String[] args) {
			
		System.out.println("파일 이름은>?");
	        File f = createFile(new Scanner(System.in).next());
	        System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
	}
	@SuppressWarnings("finally")
	static File createFile(String fileName)  {
	    try {
			if(fileName == null || fileName.equals("")) {
			    throw new Exception("파일 이름이 적절하지 않습니다");
			}
		} catch (Exception e) {
			fileName = "Untitled.txt";
		}finally {
			File f= new File(fileName);
			createNF(f);
			return f;
		}
	}
	
	static void createNF (File f) {
		try {
			f.createNewFile();
		}catch (Exception e) {
		}
	}
}
