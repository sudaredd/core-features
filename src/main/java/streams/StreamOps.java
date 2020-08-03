package streams;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class StreamOps {

	static List<Dish> dishes = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );
	
	public static void distintEx() {
		List<Integer> numbers = Arrays.asList(6, 2, 1, 3, 3, 2, 4);
		System.out.println("------distintEx---------");
		numbers.stream()
		.filter(i -> i % 2 == 0)
		.distinct()
		.forEach(System.out::println);
	}
	
	public static void limitEx() {
		System.out.println("------limitEx---------");
		dishes.stream().filter(d->d.getCalories() >300)
		.map(Dish::getName).limit(3).forEach(System.out::println);
	}
	
	public static void skipLimitEx() {
		System.out.println("---------skipLimitEx--------");
		dishes.stream().skip(2).
		filter(d->d.getCalories() >300)
		.map(Dish::getName).limit(3).forEach(System.out::println);
	}
	
	public static void splitEachChar() {
		System.out.println("--------splitEachChar-------");
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		words.stream()
		.map(word -> word.split("")).flatMap(Arrays::stream)
		.distinct().forEach(System.out::println);
		//.collect(Collectors.toList());
	}
	
	//square of each number
	public static void quiz1() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> squares = numbers.stream().map(i->i*i).collect(toList());
		System.out.println("numbers :"+numbers);
		System.out.println("squares :"+squares);
	}
	
	//map first List each element to second list element
		public static void quiz2() {
			List<Integer> numbers1 = Arrays.asList(1,2,3);
			List<Integer> numbers2 = Arrays.asList(3,4,5);
			
			List<Object> pairs =
					numbers1.stream()
					.flatMap(i -> numbers2.stream()
					.map(j -> new int[]{i, j})
					)
					.collect(toList());
			System.out.println("squares :"+pairs);
		}
	
	public static void main(String[] args) {

		distintEx();
		limitEx();
		skipLimitEx();
		splitEachChar();
		quiz1();
		quiz2();
	}

}
