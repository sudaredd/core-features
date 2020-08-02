package defaultF;

@FunctionalInterface
interface Calc {
	double calc(int val);
	
	public default double sqrt(int val) {
		return Math.sqrt(val);
	}
	
	public default double square(int val) {
		return val * val;
	}
}
public class CalcMain {

	public static void main(String[] args) {

		Calc sqrtC = new Calc() {
			@Override
			public double calc(int val) {
				return sqrt(val);
			}
		};
		
		Calc squareC = new Calc() {
			@Override
			public double calc(int val) {
				return square(val);
			}
		};
		
	//	Calc sqrtL = val->sqrt(val);
	}
}
