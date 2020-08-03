package com.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JmsHello {

	@Benchmark
	public void wellHelloThere() {
		// this method was intentionally left blank.
	}

	public static void main(String[] args) throws RunnerException {

		Options opt = new OptionsBuilder()
				.include(JmsHello.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();
	}

}
