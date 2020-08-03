package com.util;

import java.util.stream.IntStream;

public class FinalThreadD {

	int x;
	
	public FinalThreadD(int x) {
		super();
		Util.pauseInSecs(1);
		System.out.println(IntStream.rangeClosed(1, 10000).count());
		this.x = x;
	}

	public int getX() {
		return x;
	}
	
	static FinalThreadD  d;


	public static void main(String[] args) {

		Runnable r = ()-> {
			d = new FinalThreadD(10);
		};
		Runnable r1 = ()-> {
			Util.pauseInSecs(1);		
			System.out.println(d.getX());
		};
		
		new Thread(r).start();
		new Thread(r1).start();
		
	}

}
