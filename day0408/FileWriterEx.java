package day0408;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {
	public static void main(String[] args) {
		String str = "C:\\Temp\\desert.txt";
		
		Scanner scanner = new Scanner(System.in);
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter(str);
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0) 
					break;
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		scanner.close();
		
		
		
	}
}
