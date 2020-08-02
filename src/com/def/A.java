package com.def;

public interface A {

	default void x() {
		System.out.println("x");
	}
}
