package day0322;

class Person_ex { 
	int a=1;
}
class Student_ex extends Person_ex { 
	int b=2;
}
class Researcher extends Person_ex {
	int c=3;
}
class Professor extends Researcher { 
	int d=4;
}


public class InstanceofEx {
	static void print(Person_ex p) {
		if(p instanceof Person_ex) {
			System.out.print("Person ");
			System.out.print(p.a);
		}
		if(p instanceof Student_ex) {
			System.out.print("Student ");
			Student_ex s = (Student_ex)p;
			System.out.print(s.b);
		}
		if(p instanceof Researcher) {
			System.out.print("Researcher ");
		}
		if(p instanceof Professor) {
			System.out.print("Professor ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		System.out.print("new Student() ->\t"); print(new Student_ex());
		System.out.print("new Researcher() ->\t"); print(new Researcher());
		System.out.print("new Professor() ->\t"); print(new Professor());
		
	}
}

