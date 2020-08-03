package functional;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerD {

	static Consumer<String> c = s1 -> System.out.println("write to mq:" + s1);
	static Consumer<String> c1 = s2 -> System.out.println("write to file:" + s2);
	static Consumer<String> c2 = s2 -> System.out.println("write to db:" + s2);
	
	public static void main(String[] args) {
		singleChain();
		chainOfConsumers();
		anonymousChain();
	}

	private static void singleChain() {
		System.out.println("------------singleChain------------------");
		c.accept("ello");
	}

	private static void chainOfConsumers() {
		System.out.println("------------chainOfConsumers------------------");
		Stream.of("1", "2").forEach(c.andThen(c1).andThen(c2));
	}

	private static void anonymousChain() {
		System.out.println("-----------------	anonymousChain()----------------------");
		Stream.of("1", "2").forEach( ((Consumer<String>) s->System.out.println("w:"+s))
														.andThen(s->System.out.println("R:"+s))
														.andThen(s->System.out.println("k:"+s)));
	}

}
