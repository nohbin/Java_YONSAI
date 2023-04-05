package day0327;

public class Card {
	static final int SPADE = 4;
	static final int DIA = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	int kind;
	int number;
	public Card() {
		this(SPADE,1);
	}
	public Card(int kind , int number) {
		this.kind = kind;
		this.number = number;
	}
	@Override
	public String toString() {
		String[]kinds = {"CLOVER","HEART","DIAMOND","SPADE"};
		String numbers = "123456789XJQK";
		return "Card [kind = " + kinds[this.kind] 
				+ ", number = "+ numbers.charAt(this.number) + "]";
	}
}

