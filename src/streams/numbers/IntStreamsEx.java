package streams.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class IntStreamsEx {

	//a*a + b*b = c*c
	public static void ex1() {
		int upperlimit = 10;
		Stream<int[]> pythagoreanTriples =  IntStream.range(1, upperlimit).boxed().
		flatMap(a->IntStream.range(a, upperlimit).		
		filter(b-> Math.sqrt(a*a+b*b)%1==0).boxed().
		map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
		pythagoreanTriples.limit(5).forEach(t-> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}
	public static void main(String[] args) {
		ex1();
		
	}

}
