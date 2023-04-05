package day0328;

class Book{
	public Book() {
		System.out.println("Book클래스 생성자 ~~ (파라미터 없음)");
		
	}
	Book(String s){
		this();
		System.out.println("Book클래스 생성자 ~~ ->" + s);
	}
}

class ComputerBook extends Book{
	
	public ComputerBook() {
	}
	public ComputerBook(String s) {
		super(s);
		System.out.println("ComputerBook 클래스 생성자");
	}
}

public class Exam {
	public static void main(String[] args) {
		ComputerBook sedan1 = new ComputerBook("굿 자바");
		
	}

}
