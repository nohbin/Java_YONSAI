package day0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Sample {
	public static void main(String[] args) throws Exception {
		Predicate<Integer> isOdd = i -> i%2==0;
		Predicate<Integer> isEven = i -> i%2==1;
		System.out.println(isOdd.and(isEven).test(4));
		System.out.println(isOdd.or(isEven).test(4));
		System.out.println(isOdd.negate().test(3));
		UnaryOperator<Integer> plus10 =i->i+10;
		UnaryOperator<Integer> mul2 = i->i*2;
		System.out.println(plus10.andThen(mul2).andThen(plus10).apply(2));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append((CharSequence) st);
		System.out.println(bw);
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken()+" ");
		}
	}
}
