package day0411;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableEx2 {
	public static void main(String[] args) {

		try {
			String fileName = "UserInfo2.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			ObjectOutputStream out = new ObjectOutputStream(bis);
			
			UserInfo u1 = (UserInfo)in.readObject();
			UserInfo u2 = (UserInfo)in.readObject();
			
			List<UserInfo> list = new ArrayList<>();
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
