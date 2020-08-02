package lamda;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestLambda {

	public  List<String> allToUpperCase(List<String> words) {
	    return words.stream()
	                .map(TestLambda::upperCase)
	                .collect(Collectors.toList());
	}
	public  List<String> uppercaseFirstChar(List<String> words) {
	    return words.stream()
	                .map(TestLambda::firstTwoUpperCase)
	                .collect(Collectors.toList());
	}
	
	public  static String upperCase(String value) {
		System.out.println("requestin method :"+value);
		return value.toUpperCase();
	}
	
	public  static String firstTwoUpperCase(String value) {
		String firstChar = new String(""+value.charAt(0));
	    firstChar = firstChar.toUpperCase();
	                    return firstChar + value.substring(1);
	}

	@Test
	public void multipleWordsToUppercase() {
	    List<String> input = Arrays.asList("a", "b", "hello");
	    List<String> result = allToUpperCase(input);
	    assertEquals(Arrays.asList("A", "B", "HELLO"), result);
	}
	
	@Test
	public void twoLetterStringConvertedToUppercaseLambdas() {
	    List input = Arrays.asList("ab");
	    List result = uppercaseFirstChar(input);
	    assertEquals(Arrays.asList("Ab"), result);
	}
}
