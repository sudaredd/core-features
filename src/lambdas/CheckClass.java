package lambdas;

public class CheckClass {

	public static void main(String[] args) {

		Runnable r1 = System.out::println;
		
		Runnable r2 = ()->System.out.println("r2");
		
		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				System.out.println("r3");
			}
		};
		
		System.out.println(r1.getClass());
		System.out.println(r2.getClass());
		System.out.println(r3.getClass());
		
		System.out.println(r1.getClass().getName());
		System.out.println(r2.getClass().getName());
		System.out.println(r3.getClass().getName());
	}

}
