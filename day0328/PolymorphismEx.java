package day0328;

class Tv{
	
	boolean power;
	int channel;
	
	void pwoer() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
	@Override
	public String toString() {
		return "Tv [power=" + power + ", channel=" + channel + "]";
	}
	
}

class CaptionTv extends Tv{
	String text = "Caption Tv";
	void caption() {}
	@Override
	public String toString() {
		return "CaptionTv [text=" + text + "]";
	}
	
}
class LcdTv extends Tv{
	String pixel = "Lcd Tv";
	void caption() {}
	@Override
	public String toString() {
		return "LcdTv [pixel=" + pixel + "]";
	}
	
}
class SmartTv extends Tv{
	String cpu = "Smart Tv";
	void caption() {}
	@Override
	public String toString() {
		return "SmartTv [cpu=" + cpu + "]";
	}
	
}


public class PolymorphismEx {
	public static void main(String[] args) {

		Tv t1 = new CaptionTv();
		Tv t2 = new LcdTv();
		Tv t3 = new SmartTv();
		print(t1);
		print(t2);
		print(t3);
		
		
		
	}
	static void print(Tv t) {
		CaptionTv ctv = null;
		LcdTv lcd = null;
		SmartTv stv = null;
		
		if(t instanceof CaptionTv) {
			ctv = (CaptionTv)t;
			System.out.println(ctv.text);
		}else if(t instanceof LcdTv) {
			lcd = (LcdTv)t;
			System.out.println(lcd.pixel);
		}else if(t instanceof SmartTv) {
			stv = (SmartTv)t;
			System.out.println(stv.cpu);
		}
	}
}
