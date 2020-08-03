package functional.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lambdas.Apple;

public class Predicates {

	static Predicate<Apple> red = a->a.getColour().equals("RED");
	static Predicate<Apple> size = a->a.getSize()>=100;
	static Predicate<Apple> red_size = red.and(size);
	
	static Predicate<Apple> green_size = ((Predicate<Apple>) a1->a1.getColour().equals("GREEN")).and(size);
	
	public static void main(String[] args) {

		 List<Apple> inventory = Arrays.asList(new Apple(126, "Green"), new Apple(100, "RED"),
				 	new Apple(155, "GREEN"));
		 
		 for(Apple a : inventory) {
			 if(red_size.or(green_size).test(a)) {
				 System.out.println(a);
			 }
		 }

	}

}
