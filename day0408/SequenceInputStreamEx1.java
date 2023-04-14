package day0408;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceInputStreamEx1 {
	public static void main(String[] args) throws Exception {

		Vector files = new Vector();
		files.add(new FileInputStream("file.001"));
		files.add(new FileInputStream("file.002"));
		SequenceInputStream in = new SequenceInputStream(files.elements());
		
		
	}
}
