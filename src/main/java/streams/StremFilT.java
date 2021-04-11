package streams;

import java.util.stream.Stream;

public class StremFilT {

	public static void main(String[] args) {

		Stream<Integer> stream = Stream.iterate(10, i->i+1);
		
		int res = stream.filter(i->i<10).findFirst().get();
		
		System.out.println(res);
		
		int y = Integer.MAX_VALUE + 1;
		System.out.println(y);
	}

}
