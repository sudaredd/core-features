package functional;

public class Functional1 {

	Runnable rL = ()->System.out.println("Lamda run");
	Runnable anonymousC = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Anonymous class run");
		}
	};
	
	public void process() {
		new Thread(rL).start();
		new Thread(anonymousC).start();
		new Thread(()->System.out.println("anonymous function run")).start();
	}
	
	public static void main(String[] args) {
		new Functional1().process();
	}
}
