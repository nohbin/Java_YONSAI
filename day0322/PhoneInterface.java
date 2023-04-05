package day0322;

public interface PhoneInterface {

	int TIMEOUT = 10000;	// public static final 생략
	void sendCall();		// public abstract 생략
	void receiveCall();		// 상동
	default void printLogo() { // default method
		System.out.println("Phone");
	}
	
}

interface Phonecheck extends PhoneInterface {
	
}

class SamsungPhone implements Phonecheck{

	@Override
	public void sendCall() {
		System.out.println("갤럭시 전화 걸기");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("삼성전화 받기");
	}
	public void flash() {
		System.out.println("불이 켜짐.");
	}
}

class Iphone implements PhoneInterface{

	@Override
	public void sendCall() {
		System.out.println("아이폰 전화걸기");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("아이폰 전화받기");
		
	}

	@Override
	public void printLogo() {
		PhoneInterface.super.printLogo();
	}
	
}