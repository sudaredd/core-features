package streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayOps {

	public static void checkImmute(Integer x) {
		x=9;
	}
	public static void main(String[] args) {

		int array[] = {2,4,5,7,8,9};
		
		System.out.println(Arrays.stream(array).sum());
		System.out.println(Arrays.stream(array).max().orElse(-1));
		System.out.println(Arrays.stream(array).min().getAsInt());
		
	System.out.println(Arrays.stream(array).mapToObj(s->s+"").collect(Collectors.joining(",")));
	
	Integer i = new Integer(90);
	
	checkImmute(i);
	
	System.out.println(i);
	}

}
