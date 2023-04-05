package day0322;

class myChar {
	char ch;
}

public class Exam {
	static void swap(myChar a, myChar b) {
		char temp;
		temp = a.ch;
		a.ch = b.ch;
		b.ch = temp;
		
		
		
		

	}
	
	public static void main(String[] args) {
		myChar ch1 = new myChar();
		myChar ch2 = new myChar();
		ch1.ch = 'A';
		ch2.ch = 'B';
		
		swap(ch1, ch2);
		System.out.println(ch1.ch);
		
				
				
	}
}


