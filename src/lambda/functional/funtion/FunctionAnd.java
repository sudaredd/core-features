package lambda.functional.funtion;

import java.util.List;
import java.util.function.Function;

public class FunctionAnd {

	public static void main(String[] args) {

		Function<Integer, Integer> inc = i1-> i1 + 1;
		Function<Integer, Integer> doubleIt = i1-> i1*2;
		
		int total = inc.andThen(doubleIt).apply(5);
		
		System.out.println(total);
		
		total = inc.compose(doubleIt).apply(5);
		
		System.out.println(total);
	}

}
