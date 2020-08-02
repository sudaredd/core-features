package defaultF;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.stream.Stream;

interface A11 {
	
	default String testA() {
		
		return "A1";
	}
}

public class TestSuper implements A11 {
	
	Consumer<String> s = String::new;

	public String testA1() {
		System.out.println(A11.super.testA());
		return A11.super.testA();
	}

	public static void main(String[] args) {
		System.out.println(new TestSuper().testA());
		
		String s = null;
	//	String hello = new String( s );
		
		PriorityQueue<String> pQueue = new PriorityQueue<String>();
        pQueue.add("Apple");
        pQueue.add("Nokia");
        pQueue.add("Samsung");
        pQueue.add("Apple");
        
        System.out.print(pQueue.poll() + " " + pQueue.poll());
        System.out.println(" " + pQueue.peek() + " " + pQueue.poll());
	}

	private static void test(List<String> object) {
		// TODO Auto-generated method stub
		
	}

}
