package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamPredicate {

	public static int sum(List<Integer> list, Predicate<Integer> p) {
		return list.stream()
		.filter(p)
		.mapToInt(i->i)
		.sum();
	}
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(9,8,7,6,5,4,3,2,1);
		
		System.out.println("sum of all numbers:"+sum(list, i->true));
		System.out.println("sum of even numbers:"+sum(list, i->i%2==0));
		System.out.println("sum of odd numbers:"+sum(list, i->i%2!=0));
		
	}

}
