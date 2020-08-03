package core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysListD {

	public static void main(String[] args) {

		String[] s = {"1","2",""};
		List<String> l = Arrays.asList(s);
		System.out.println(l);
		s[2]="3";
		s[1]="10";
		System.out.println(l);
		
		
		List<String> ll = IntStream.range(1, 10).mapToObj(i->i+"").collect(Collectors.toList());
		System.out.println(ll);
		ll.removeIf(i->i.equals("1"));
		System.out.println(ll);
		
	}

}
