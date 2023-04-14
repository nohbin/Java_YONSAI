package day0411;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableEx1 {
	public static void main(String[] args) {

		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("javaman","1234",30);
			UserInfo u2 = new UserInfo("javaWoman","4321",26);
			
			List<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("직렬화가 끝났습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
