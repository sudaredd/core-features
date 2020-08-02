package core8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
		List<String> l = Arrays.asList("das","darsa","kasi");
		System.out.println(l);
		Collections.sort(l,Comparator.comparing((String s)->s));
		System.out.println(l);
	}
}
