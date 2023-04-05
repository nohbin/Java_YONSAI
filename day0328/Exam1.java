package day0328;
interface Animal{
	void bear();
}

interface Fish{
	void swim();
}

class Whale implements Animal,Fish{

	@Override
	public void swim() {
		System.out.println("고래는 물속에서 삽니다.");
	}

	@Override
	public void bear() {
		System.out.println("고래는 새끼를 낳습니다.");
		
	}
	
}
public class Exam1 {
	public static void main(String[] args) {
		Whale tank1 = new Whale();
		tank1.bear();
		tank1.swim();
	}

}
