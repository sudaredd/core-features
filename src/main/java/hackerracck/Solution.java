package hackerracck;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

	//	leftRotate();
		
	//	sparseArrays();
		
		int i[]= {1,3,1,4,5,6,3,2};
		List<Integer> duplicates = IntStream.of( i)
                .boxed()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
                .entrySet()
                .stream()
                .filter( p -> p.getValue() > 1 )
                .map( e -> e.getKey() )
                .collect( Collectors.toList() );
		Integer [] dups= duplicates.toArray(new Integer[duplicates.size()]);
		
Arrays.stream(dups).forEach(System.out::println);
	}

	private static void sparseArrays() {
		Map<String, Long> map= IntStream.range(0, scanner.nextInt())
		.mapToObj(i->scanner.next())
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		IntStream.range(0, scanner.nextInt())
		.mapToObj(i->scanner.next())
		.map(obj->map.getOrDefault(obj, 0L))
		.forEach(System.out::println);
	}

	private static void leftRotate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter size");
		int size = scanner.nextInt();
		
		System.out.println("enter no of elements to rotate");
		int rotate = scanner.nextInt();
		
		int ary[] = new int[size];
		int rotAry[] = new int[size];
		IntStream.range(0, size).forEach(s->ary[s]=scanner.nextInt());
		IntStream.range(0, size).forEach(i->rotAry[i]=ary[(rotate+i)%size]);
		
		Arrays.stream(ary).forEach(System.out::print);
		System.out.println();
		Arrays.stream(rotAry).forEach(System.out::print);
	}

}
