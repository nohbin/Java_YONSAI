package day0328;

class Product{
	int price;
	int bonusPoint;
	
}

class Tv1 extends Product {
	
}

class Computer extends Product{
	
}

class Audio extends Product{
		
}

class Buyer{
	int money = 1000;
	int bonusPoint = 0;
	
	void buy (Product p) {
		money -= p.price;
		bonusPoint += p.bonusPoint;
	}
}

public class PolymorphismEx1 {

}
