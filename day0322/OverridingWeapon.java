package day0322;
class Weapon{
	protected int fire() {
		return 1;
	}
}

class Cannon extends Weapon{

	@Override
	protected int fire() {
		return 10;
	}
	
}

public class OverridingWeapon {
	public static void main(String[] args) {
		
		
		
		Weapon weapon  = new Weapon();
		int a = weapon.fire();
		System.out.println("kill : " + a);
		weapon = new Cannon();
		a = weapon.fire();
		System.out.println("kill : " + a);
		
	}

}
