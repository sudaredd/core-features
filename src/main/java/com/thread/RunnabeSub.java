package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnabeSub {

	static Runnable r1 = ()->{
		System.out.println("r1");
		throw new RuntimeException("check ex");
	};
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future f = executorService.submit(r1);
		System.out.println("output::"+f.get());
	}

}
