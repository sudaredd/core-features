package com.util;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerDemo {

	public static void main(String[] args) {

		StringJoiner sj = new StringJoiner(":", "[", "]");
		sj.add("George").add("Sally").add("Fred");
		String desiredString = sj.toString();
		
		System.out.println(desiredString);
		
		final List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
		final String collectJoin = strings.stream().collect(Collectors.joining(", "));
		System.out.println(collectJoin);


	}

}
