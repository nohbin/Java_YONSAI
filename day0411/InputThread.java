package day0411;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class InputThread extends Thread {
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	
	public InputThread(String name) {
		super(name);
		System.out.println("input 생성자");
	}
	
	public void run() {
		System.out.println("in run");
		try {
			int data = 0;
			
			while ((data=input.read()) != -1) {
				sw.write(data);
			}
			System.out.println(getName() + " received : " + sw.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public PipedReader getInput() {
		return input;
	}
	public void connect(PipedWriter output) {
		try {
			input.connect(output);
			System.out.println("input connect");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
