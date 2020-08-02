package core8;

import java.util.concurrent.Callable;


public class ello {
	interface HelloService {
		String hello(String firstname, String lastname);
    }
	public static void main(String[] args) {

		int i=0;
		HelloService helloService=(String firstname, String lastname) -> 
		{ 
			  
			String hello="Hello " + firstname + " " + i+ lastname; 
			return hello;
			
			
		};
	
		
		new Thread(() -> {
	         System.out.println("Hello from a thread");
	 		System.out.println(helloService.hello("as","shole"));	

		}).start();
		
	
		  try {

		         Callable<String> c = () -> {
		        	 System.out.println(helloService.hello("as","555"));
		         return "Hello from Callable";
		         };
		         System.out.println(c.call());
		      } catch (Exception e) {
		         System.err.println(e.getMessage());
		      }
	
	}

}
