package day0327;

public class Deck {
	final static int CARD_NUM = 52;
	Card[] cardArr = new Card[CARD_NUM];
	public Deck() {
		int i = 0;
		for (int k = 0; k < Card.KIND_MAX; k++) {
			for (int n = 0; n < Card.NUM_MAX; n++) {
				cardArr[i++] = new Card(k,n);
				}
		}
	}
	void shuffle() {
		for (int i = 0; i <CARD_NUM; i++) {
			int r = (int)(Math.random()*CARD_NUM);
			Card temp = cardArr[i];
			cardArr[i]=cardArr[r];
			cardArr[r]= temp;
		}
	}
	
	Card pick(int index) {
		return cardArr[index];
	}
	Card pick() {
		int index = (int)(Math.random()*CARD_NUM);
		return pick(index);
		
	}
	
}
