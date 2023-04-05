package day0331;

class Card implements Cloneable {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	public Card(String kind, int number) {
		super();
		this.kind = kind;
		this.number = number;
	}

	@Override
	protected Card clone()  {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return (Card) obj;
	}

	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}

}

public class CloneEx {
	public static void main(String[] args) {
		Card c1 = new Card("Spade", 1);
		Card c2= (Card) c1.clone();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.kind.equals(c2.kind));
		
		
		
	}
}
