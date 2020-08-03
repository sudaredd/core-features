package com.util;

import java.util.concurrent.TimeUnit;

public class Util {

	public static void pauseInSecs(int i) {
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void pauseInMilliSecs(int i) {
		try {
			TimeUnit.MILLISECONDS.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
