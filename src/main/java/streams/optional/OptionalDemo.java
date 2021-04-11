package streams.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {

		Optional<String> opt = Optional.of("Hello");
		Optional<String> opt1 = Optional.empty();
		
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}
		System.out.println(opt.orElse("non empty"));
		System.out.println(opt1.orElse("empty original"));
	}

}
