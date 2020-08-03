package functional.predicate;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericOpsPredicates {

	public static boolean isEven(int num) {
		return num%2==0;
	}
	public static boolean isOdd(int num) {
		return num%2!=0;
	}
	static IntPredicate isEvenP = NumericOpsPredicates::isEven;
	static IntPredicate isOddP = NumericOpsPredicates::isOdd;
	public static void main(String[] args) {
		List<Integer> evenL = IntStream.range(0, 100).filter(isEvenP).boxed().collect(toList());
		List<Integer> oddL = IntStream.range(0, 100).filter(isOddP).boxed().collect(toList());
		
		Map<Boolean, List<Integer>> allRes = IntStream.range(0, 100).boxed().collect(Collectors.partitioningBy(i->i%2==0));
		Map<Boolean, List<Integer>> allRes1 = IntStream.range(0, 100).boxed().collect(Collectors.groupingBy(i->i%2==0));

		System.out.println("evenL"+evenL );
		System.out.println("oddL"+oddL );
		
		System.out.println(allRes);
		System.out.println(allRes1);
	}

}
