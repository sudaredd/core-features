package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        System.out.println(sumOfOddNumbers(Arrays.asList(1, 2, 3, 4, 5)));
    }

    private static int sumOfOddNumbers(List<Integer> numbers) {
        /*return numbers.stream()
            .filter(num -> num % 2 != 0)
            .map(n -> n * n)
            .mapToInt(i -> i)
            .sum();*/

       /* return numbers.stream()
            .filter(num -> num % 2 != 0)
            .map(n -> n * n)
            .reduce(0, (a, b) -> a + b);*/

        return numbers.stream()
            .filter(num -> num % 2 != 0)
            .map(n -> n * n)
            .reduce((a, b) -> a + b).get();
    }
}
