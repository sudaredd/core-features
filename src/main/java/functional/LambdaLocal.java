package functional;

public class LambdaLocal {

	public static void main(String[] args) {

		String x ="hello";
		
		Runnable r = ()-> {
			//can't reassign
			//x = "Hello";
			System.out.println(x+"kk");
		};
	}

}
