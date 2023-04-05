package day0329;

abstract class Player{
	static int currentPos ;
	
	Player(){
		
		System.out.println(currentPos);
		currentPos++;
	}
	abstract void play(int pos);
	abstract void stop();
	
	void play() {
		play(currentPos);
	}
}

class AudioPlayer extends Player{

	@Override
	void play(int pos) {
		// TODO Auto-generated method stub
		System.out.println("Audio Player play"+pos);
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("Audio Player stop");
	}

	public AudioPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

public class Abstract {
	public static void main(String[] args) {
		AudioPlayer ap = new AudioPlayer();
		AudioPlayer ap2 = new AudioPlayer();
		ap.play();
		ap.play();
		ap.stop();
	}

}
