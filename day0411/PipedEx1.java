package day0411;

public class PipedEx1 {
	public static void main(String[] args) {
		
		System.out.println("main start");
		InputThread inThread = new InputThread("Input Thread");
		OutputThread outThread = new OutputThread("Output Thread");
		inThread.connect(outThread.getOutput());
		inThread.start();
		outThread.start();
		System.out.println("main end");
		
	}
}
