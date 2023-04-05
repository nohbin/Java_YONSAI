package day0330;

import java.io.File;
import java.util.Scanner;

public class ExceptionEx5 {
	public static void main(String[] args) {
		
	        try {
				File f = createFile(new Scanner(System.in).next());
				System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	static File createFile(String fileName) throws Exception  {
			if(fileName == null || fileName.equals("")) {
			    throw new Exception("파일 이름이 적절하지 않습니다");
			}
			File f= new File(fileName);
			f.createNewFile();
			return f;
		}
	}
	

