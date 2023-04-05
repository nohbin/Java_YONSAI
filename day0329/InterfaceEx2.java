package day0329;

interface I{
	public void play();
}

class AA {
	public void play(I o) {
		o.play();
	}
}

class BB implements I{

	@Override
	public void play() {
		System.out.println("BB.play()");
	}

}

class CC implements I {
	public void play() {
		System.out.println("CC.play()");
	}
}

public class InterfaceEx2 {
	public static void main(String[] args) {
		I bb = new BB();
		I cc = new CC();
		
	}
}
