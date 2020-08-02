package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sd {

	public static int transform(int v) {
		System.out.println("value is :"+v );
		return v;
	}
	
	public static void process(Stream<Integer> stream) {
		System.out.println("loop through stream");
		
		stream.forEach(System.out::println);
	}
	public static void main(String[] args) {

		List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Stream<Integer> s= l.stream()
		.map(Sd::transform)
		.filter(i->i>0);
		System.out.println("calling process");
		process(s);
	}

}
