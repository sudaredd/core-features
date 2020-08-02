package streams.collectors;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import streams.Dish;

public class Ex1 {
	public enum CaloricLevel { DIET, NORMAL, FAT }
	static List<Dish> menu = Dish.dishes();
	public static void ex1() {
		String shortMenu = menu.stream().map(Dish::getName).collect(joining(","));
		
		System.out.println(shortMenu);
		
		shortMenu = menu.stream().map(Dish::getName)
				.collect( reducing( (s1, s2) -> s1 +","+ s2 ) ).get();
		System.out.println(shortMenu);
	}
	
	public static void groupBy() {
	 Map<Dish.Type, List<Dish>>	groupByTyp= menu.stream().collect(groupingBy(Dish::getType));
	 System.out.println(groupByTyp);
	}
	
	public static void groupByComplex() {
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
				.collect(groupingBy(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}));

		System.out.println("dishesByCaloricLevel:" + dishesByCaloricLevel);
		dishesByCaloricLevel = menu.stream().collect(groupingBy(d -> {
			if (d.getCalories() <= 500)
				return CaloricLevel.DIET;
			else if (d.getCalories() <= 800)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		}));
		System.out.println("dishesByCaloricLevel:" + dishesByCaloricLevel);
	}
	
	public static void multilevelGroup() {
		 Map<Dish.Type,Map<CaloricLevel, List<Dish>>> dishesByCaloricLevel = menu.stream()
				.collect(
						groupingBy(Dish::getType, 
						groupingBy(dish -> { 
							if (((Dish) dish).getCalories() <= 400)
								return CaloricLevel.DIET;
							else if (((Dish) dish).getCalories() <= 700)
								return CaloricLevel.NORMAL;
							else
								return CaloricLevel.FAT;
				})));
		System.out.println("multilevelGroup():" + dishesByCaloricLevel);
	}
	public static void groupByComplexWithFun() {
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
				.collect(groupingBy(Ex1::getCalorilevel));

		System.out.println("dishesByCaloricLevel using groupByComplexWithFun:" + dishesByCaloricLevel);
	}
	
	public static CaloricLevel getCalorilevel(Dish dish) {
		if(dish.getCalories() < 400)
			return CaloricLevel.DIET;
		else if(dish.getCalories() < 700)
			return CaloricLevel.NORMAL;
		else return CaloricLevel.FAT;
	}
	
	public static void groupByCounting() {
		 Map<Dish.Type, Long>	groupByCount= menu.stream().collect(groupingBy(Dish::getType,counting()));
		 System.out.println(groupByCount);
	}
	
	public static void main(String[] args) {
		ex1();		
		groupBy();
		groupByComplex();
		multilevelGroup();
		groupByCounting();
		groupByComplexWithFun();
	}
}
