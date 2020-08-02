package optionals;

import java.util.Optional;

class Emp {
	String name;

	public Emp() {
		super();
	}

	public Emp(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

public class OptionalD {

	public static void main(String[] args) {

		Optional.ofNullable(new Emp()).map(Emp::getName).map(String::toUpperCase).ifPresent(System.out::println);
		Optional.ofNullable(new Emp("darsan")).map(Emp::getName).map(String::toUpperCase).ifPresent(System.out::println);

	}

}
