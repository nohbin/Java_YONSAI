package day0322;

public class PhoneInterfaceEx {
	public static void main(String[] args) {

		PhoneInterface sp = new SamsungPhone();

		sp.receiveCall();
		sp.sendCall();
		((SamsungPhone)sp).flash();
		int a = PhoneInterface.TIMEOUT;
		System.out.println(a);
		sp.printLogo();
		
		Iphone ip = new Iphone();
		sp = ip;
				
		sp.sendCall();
		sp.receiveCall();
		sp.printLogo();
		int b= PhoneInterface.TIMEOUT;
		System.out.println(b);
	}
}
