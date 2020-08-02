package defaultF;

interface A1 {
	default void test(){
		System.out.println("test base");
	}
/*	
	public static void test2(){
			System.out.println("test static");
		}*/
}

interface A2 {
	default void test(){
		System.out.println("test sub");
	}
	public static void test2(){
		System.out.println("test static sub");
	}
}
public class Default1 implements A1,A2 {
	 public void test(){
			System.out.println("test sub class");
		}
	public static void main(String[] args) {

		A1 a =new Default1();
		a.test();
		A2.test2();
		/**
		 * When you implement an interface that contains a static method, 
		 * the static method is still part of the interface and not part of the implementing class. 
		 * For this reason, you cannot prefix the method with the class name. Instead, you must prefix the method with the interface name
		 */
//		a.test2();
	}

}
