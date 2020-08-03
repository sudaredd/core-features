package functional.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lambdas.Apple;

//@FunctionalInterface
interface ApplePredicate<T> {
	
	public boolean test(Apple apple);
}

class GreenApplePredicate implements ApplePredicate<Apple> {

	@Override
	public boolean test(Apple apple) {
		return "GREEN".equalsIgnoreCase(apple.getColour());
	}

}

class GreenAppleThinPredicate implements ApplePredicate<Apple> {

	@Override
	public boolean test(Apple apple) {
		return "GREEN".equalsIgnoreCase(apple.getColour()) && apple.getSize() <150;
	}
}

class RedApplePredicate implements ApplePredicate<Apple> {

	@Override
	public boolean test(Apple apple) {
		return "RED".equalsIgnoreCase(apple.getColour());
	}
}


public class AppleFilter {

 public static void main(String[] args) {
	 List<Apple> inventory = Arrays.asList(new Apple(126, "Green"), new Apple(100, "RED"), new Apple(155, "GREEN"));
	 
	 System.out.println(filterNoLambda(inventory, new GreenApplePredicate()));
	 
	 System.out.println(filterNoLambda(inventory, new GreenAppleThinPredicate()));
	 
	 System.out.println(filterNoLambda(inventory, new RedApplePredicate()));
	 
	 List<Apple> result = filter(inventory, (apple)->"Green".equalsIgnoreCase(apple.getColour()));
	 
	 System.out.println("with Lambdas GreenApplePredicate:"+result);
	 
	 result = filter(inventory, (apple)->"GREEN".equalsIgnoreCase(apple.getColour()) && apple.getSize() <150);
	 
	 System.out.println("with Lambdas GreenAppleThinPredicate:"+result);
	 
	 result = filter(inventory, (apple)->"RED".equalsIgnoreCase(apple.getColour()));
	 
	 System.out.println("with Lambdas RedAppleThinPredicate:"+result);
 
 }
 

 public static List<Apple> filterNoLambda(List<Apple> inventory, ApplePredicate<Apple> p) {
	 List<Apple> result = new ArrayList<Apple>();
	 for(Apple apple : inventory) {
		 if(p.test(apple)) {
			 result.add(apple);
		 }
	 }
	 return result;
 }

public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
	return inventory.stream()
	.filter(p)
	.collect(Collectors.toList());
 }
	
}