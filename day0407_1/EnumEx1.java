package day0407_1;

import java.util.function.Consumer;

enum Direction {
	EAST, SOUTH, WEST, NORTH
}

public class EnumEx1 {
	public static void main(String[] args) {
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Direction.valueOf(Direction.class, "EAST");
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		System.out.println("d1 == d2 : " + (d1==d2));
		System.out.println("d1 == d3 : " + (d1==d3));
		System.out.println("d1.equals(d3) :  "+ d1.equals(d3));
		System.out.println("d1.compareTo(d3) : " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) : " + (d1.compareTo(d2)));
		
		switch (d1) {
		case EAST:
			System.out.println("the direction is EAST.");
			break;
		case SOUTH:
			System.out.println("the direction is SOUTH.");
			break;
		case WEST:
			System.out.println("the direction is WEST.");
			break;
		case NORTH:
			System.out.println("the direction is NORTH.");
			break;
		default:
			System.out.println("Invalid direction");
			break;
		}
		Direction[]arr = Direction.values();
		for (Direction d : arr) {
			System.out.printf("%s=%d\n",d.name(),d.ordinal());
		}
		
		Consumer<String> a1 = (String s1)-> System.out.println(s1);
		a1.accept("Hello world");
		
		
	}
}
