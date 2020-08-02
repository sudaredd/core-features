package defaultF;

interface A {
	default void dis() {
		System.out.println("hello A");
	}
	 static void dis1() {
		System.out.println("dis1 A");
	}
}

interface B extends A {
	default void dis() {
		System.out.println("hello B");
	}
	static void dis1() {
		System.out.println("dis1 B");
	}
}

abstract class D implements A {
	public  void dis() {
		System.out.println("hello D");
	}
	//force to implement in subcalss
	//public abstract void dis() ;
}

class C extends D implements A, B {
	
}
public class DefaultDemo {

	public static void main(String[] args) {

		new C().dis();
		B.dis1();
	}

}
