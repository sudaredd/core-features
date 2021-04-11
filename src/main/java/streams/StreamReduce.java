package streams;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {

	public static void main(String[] args) {

		List<Integer> l  = Arrays.asList(1,2,3,4);
		
		l.stream()
		.reduce(0, (a,b)->{
			System.out.println("a:"+a + " ,b:"+b);
			return a+b;
		});
	}

}
