package com.util;

public class StringC {

	public static void main(String[] args) {

		String first = "hello";
		String sec = "hel"+"lo";
		String third = " num";
		System.out.println(first==sec);
		System.out.println(first+third);
		System.out.println(first+third=="hello num");

		System.out.println((first+third).equals("hello num"));
	}

}
