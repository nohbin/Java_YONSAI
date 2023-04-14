package day0411;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferReaderEx1 {
	public static void main(String[] args) {

			try {
				FileReader fr = new FileReader("BufferReaderEx1.java");
				BufferedReader br = new BufferedReader(fr);
				
				String line = "";
				for (int i = 1 ;(line = br.readLine()) != null; i++) {
					if(line.indexOf(";") != -1) {
						System.out.println(i + ":"+line);
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	}
}
