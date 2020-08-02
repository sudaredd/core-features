package stream;

import java.util.Arrays;

public class StreamOperations {

	public static int peekD(int ary[]) {

		return Arrays.stream(ary)
		.peek(i-> System.out.println("takig integer:"+i))
		.filter(i->i%2==1).peek(i->System.out.println("after filter:"+i))
		.map(i->i*i).peek(i->System.out.println("after square:"+i))
		.reduce(0,Integer::sum);
				
		
	}
}
