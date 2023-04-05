package day0329;

public interface Repairable {
	class Unit {
		int hitPoint;
		final int MAX_HP;

		Unit(int hp) {
			MAX_HP = hp;
		}
	}

	class GroundUnit extends Unit {

		GroundUnit(int hp) {
			super(hp);
		}
	}
	class AirUnit extends Unit{

		public AirUnit(int hp) {
			super(hp);
		}
		
	}
	class Tank extends GroundUnit implements Repairable{

		public Tank() {
			super(150);
			hitPoint = MAX_HP;
		}

		@Override
		public String toString() {
			return "Tank";
		}
	}
	class Scv extends GroundUnit implements Repairable{

		public Scv() {
			super(100);
		}

		void repair(Repairable r) {
			if(r instanceof Unit) {
				Unit n = (Unit)r;
				while (n.hitPoint != n.MAX_HP) {
					n.hitPoint++;
				}
				System.out.println(n+" 의 수리가 끝났습니다.");
			}
		}

		@Override
		public String toString() {
			return "Scv";
		}
		
		
	}
	class Marin extends Unit{
		public Marin() {
			super(50);
		hitPoint = MAX_HP;
		}
	}
	
	public static void main(String[] args) {
		Tank tank = new Tank();
		Marin marine = new Marin();
		Scv scv = new Scv();
		scv.repair(tank);
		scv.repair(scv);
		
		
	}

}
