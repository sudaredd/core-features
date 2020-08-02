package lambda.functional.funtion;

import java.util.function.Function;

public class FunctionMethods {

	public static int andThen(int val) {
		Function<Integer, Integer> f1 = x->x+1;
		Function<Integer, Integer> f2 = x->x*2;
		Function<Integer, Integer> f3 = f1.andThen(f2);
		return f3.apply(val);
	}
	
	public static int compose(int val) {
		Function<Integer, Integer> f1 = x->x+1;
		Function<Integer, Integer> f2 = x->x*2;
		Function<Integer, Integer> f3 = f1.compose(f2);
		return f3.apply(val);
	}
	
	public static void main(String[] args) {

		System.out.println(andThen(2));
		System.out.println(compose(3));
	}

}
