package com.def;


interface Formula {
	double calculate(int a);
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
	default int Sqre(int x) {
		return x*x;
	}
}
public class DefaultInterfaecDemo {
	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a*100);
			}
		};
		System.out.println(formula.calculate(100));     // 100.0
		System.out.println(formula.sqrt(16));
		System.out.println(formula.Sqre(5));
		
		Runnable r = () -> {
			System.out.println("hello world1");
			System.out.println("hello world2");
		};
		new Thread(r).start();
	}
}
