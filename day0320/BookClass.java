package day0320;

import java.util.Scanner;



public class BookClass {
	String title;
	String author;
	public BookClass(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}	
	public static void main(String[] args) {
		Book[]book = new Book[5];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < book.length; i++) {
			System.out.print("제목 >> ");
			String title = sc.next();
			System.out.print("저자 >>");
			String author = sc.next();
			book[i] = new Book(title, author);
		}
		
		for (int i = 0; i < book.length; i++) {
			System.out.println("(" + book[i].title + " , " + book[i].author + ")");
		}sc.close();
	}
}
