package day0327;

public class DeckTest {
	public static void main(String[] args) {
		Deck d = new Deck();
		
		Card c= d.pick();
		System.out.println(c);
	}
}

