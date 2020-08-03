package streams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Stream1 {
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
	public static void printTop3Dishes() {
		List<String> top3Dish = dishes.stream().
		filter(d->d.getCalories() >300)
		.map(Dish::getName).limit(3).collect(toList());
		System.out.println(top3Dish);
	}
	public static void printTop3DishesFlow() {
		List<String> top3Dish = dishes.stream().//parallel().
		filter(d-> 
		{
			System.out.println("filtering :"+d);
			return d.getCalories() >700;
		})
		.map(d-> {
			System.out.println("mapping :"+d);
			return d.getName();}).
		
		limit(3).collect(toList());
		System.out.println(top3Dish);
	}
	public static void main(String[] args) {
		printTop3DishesFlow();
	}

}
