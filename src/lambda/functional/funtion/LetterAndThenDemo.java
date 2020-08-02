package lambda.functional.funtion;

import java.util.function.Function;

public class LetterAndThenDemo {

	public static String formatLetter(String text) {
		
		Function<String, String> addHeader = headerFun();
		Function<String, String> transformationPipeline
		= addHeader.andThen(Letter::checkSpelling)
		.andThen(Letter::addFooter);
		return transformationPipeline.apply(text);
	}

	private static Function<String, String> headerFun() {
		return Letter::addHeader;
	}
	
	public static String formatLetterWithNoSpell(String text) {
		
		Function<String, String> addHeader = headerFun();
		Function<String, String> transformationPipeline
		= addHeader.andThen(Letter::addFooter);
		return transformationPipeline.apply(text);
	}
	
	public static void main(String[] args) {

		System.out.println(formatLetter("labda"));
		
		System.out.println(formatLetterWithNoSpell("labda"));
	}

}
