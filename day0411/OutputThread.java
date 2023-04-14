package day0411;

import java.io.PipedReader;
import java.io.PipedWriter;

public class OutputThread extends Thread{
	PipedWriter output = new PipedWriter();
	
	public OutputThread(String name) {
		super(name);
		System.out.println("Output 생성자");
	}
	
	public void run() {
		System.out.println("out run");
		try {
			String msg = "Hello";
			System.out.println(getName() + " sent : " + msg);
			output.write(msg);
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);
			System.out.println("output connect");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
