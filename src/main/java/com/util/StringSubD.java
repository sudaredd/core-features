package com.util;

public class StringSubD {

	public static void main(String[] args) {

		char []c = {'1','2','3','3'};
		
		String s = new String(c, 1, 2);
		System.out.println(s);
		
		Integer i = 42;
		
		String res = i<40 ? "bst pra" :  i > 50 ? "powerfull cde" : "Bugs free,";
		res+= (i<42) ? "Best programming" : (i<30) ? (i>41) : " no stress";
		
		System.out.println(res);
	}

}
