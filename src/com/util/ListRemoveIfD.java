package com.util;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveIfD {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("");list.add(null);
		System.out.println("".length());
		try {
			list.removeIf(String::isEmpty);
		} catch(Throwable t) {
			System.out.println("wrong");
		}
		System.out.println(list.size());
	}

}
