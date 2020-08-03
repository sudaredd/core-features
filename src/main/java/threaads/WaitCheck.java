package threaads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitCheck {

	public static void main(String[] args) {

		testwait();
	}

	private static void testwait() {

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		Runnable r = ()->WaitCheck.print();

		for(int i=0;i<3;i++) executorService.execute(WaitCheck::print);
		
		executorService.shutdown();

	}
	
	public static synchronized void print()  {
		System.out.println("ready to print:"+currentThread());
		try {
			WaitCheck.class.wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("out of sllep:"+currentThread());
	}

	private static String currentThread() {
		return Thread.currentThread().getName();
	}

}
