package core8;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Stream1 {

	public static void main(String[] args) {
		List<String>  l = Arrays.asList("sudar","darsan","kasi");
		l.stream().filter(s->s.contains("da")).collect(toList());
	}

}
