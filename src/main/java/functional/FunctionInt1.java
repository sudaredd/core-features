package functional;

import java.util.Arrays;
import java.util.List;

import lambdas.Apple;
import static java.util.Comparator.comparing;

public class FunctionInt1 {

	 public List<Apple> sortLamda() {
		 List<Apple> inventory = Arrays.asList(new Apple(126, "Green"), new Apple(100, "RED"), new Apple(155, "GREEN"));
		  inventory.sort((a1,a2)->a1.getSize() - a2.getSize());
		  return inventory;
	 }
	 
	 public List<Apple> sortMethodExpression() {
		 List<Apple> inventory = Arrays.asList(new Apple(126, "Green"), new Apple(100, "RED"), new Apple(155, "GREEN"));
		  inventory.sort(comparing(Apple::getColour));
		  return inventory;
	 }
	 public List<Apple> reverseSortMethodExpression() {
		 List<Apple> inventory = Arrays.asList(new Apple(126, "Green"), new Apple(100, "RED"), new Apple(155, "GREEN"));
		  inventory.sort(comparing(Apple::getColour).reversed());
		  return inventory;
	 }
	 public List<Apple> SortMethodThenComparingExpression() {
		 List<Apple> inventory = Arrays.asList(new Apple(196, "GREEN"), new Apple(200, "RED"), new Apple(155, "GREEN"));
		  inventory.sort(comparing(Apple::getColour).thenComparing(comparing(Apple::getSize)));
		  return inventory;
	 }
	 
	public static void main(String[] args) {
		FunctionInt1 f1 = new FunctionInt1();
		System.out.println(f1.sortLamda());
		System.out.println(f1.sortMethodExpression());
		System.out.println(f1.reverseSortMethodExpression());
		System.out.println(f1.SortMethodThenComparingExpression());

	}

}
