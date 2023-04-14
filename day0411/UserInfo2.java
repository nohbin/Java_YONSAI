package day0411;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class SuperUserInfo {
	String name;
	String password;
	SuperUserInfo() {
		this("Unknown", "1111");
	}
	public SuperUserInfo(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
}

public class UserInfo2 extends SuperUserInfo implements java.io.Serializable{
	int age;
	public UserInfo2() {
		this("Unknown","1111",0);
	}
	public UserInfo2(String name , String password , int age) {
		super(name,password);
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo2 [name = " + name + "age = " + age +  ", password = " + password + "]";
	}
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		name = in.readUTF();
		password = in.readUTF();
		in.defaultReadObject();
	}
	
}
