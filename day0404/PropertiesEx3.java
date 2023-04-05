package day0404;

import java.io.IOException;
import java.lang.Runtime.Version;
import java.util.Properties;

public class PropertiesEx3 {
	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		p.setProperty("time", "30");
		p.setProperty("language", "Kor");
		p.setProperty("size", "10");
		p.setProperty("capacity", "10");
		
//		p.store(new FileOutputStream("out.txt"), "Properties Example");
//		p.storeToXML(new FileOutputStream("out.xml"), "good");
		
		Properties sysP = System.getProperties();
		System.out.println(sysP.getProperty("time"));
		
		Version version = Runtime.version();
		System.out.println(version);
		
	}
}
