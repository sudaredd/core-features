package core8;

public class Test {
	
	public static class A {
		public static void main(String[] args) {
			System.out.println("Inside thread");
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("calling from main");
		A.main(null);
		 
	}

}
