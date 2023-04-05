package day0327;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
interface FunctionalInterface {
	public abstract void doSomething(String text);
}
public class Demo1 {

	public static void main(String[] args) {
		int []a = {4,5,1,13,8,21,6,2,11,3,7,55,33,22,54};
		
		
		
		Arrays.sort(a);
		
		
		
		Consumer<String> printString = text -> System.out.println("Miss " + text + "?");
//		printString.accept("me");
		printString.andThen(printString).accept("me");
		
		Function<Integer, Integer> mul = x -> x*2;
		Integer is = mul.apply(3);
		System.out.println(is);
		
		FunctionalInterface func = text -> System.out.println(text);
		func.doSomething("hello");
		
		FunctionalInterface fc = new FunctionalInterface() {
			
			@Override
			public void doSomething(String text) {
				System.out.println(text);
				
			}
		};
		
		fc.doSomething("wow");
	
	}
	

}

