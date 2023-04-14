package day0408;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataInputStreamEx2 {
	public static void main(String[] args) throws Exception {
		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		
		
		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			while (true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
		} catch (EOFException e) {
			// TODO: handle exception
			System.out.println("점수의 총합은 " + sum + " 입니다.");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(dis!=null)
					dis.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
	}
}
