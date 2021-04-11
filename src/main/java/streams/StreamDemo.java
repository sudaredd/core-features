package streams;

import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		Stream<String> s1 = Stream.of("Str1");
		
		s1.forEach(System.out::println);
		System.out.println("---------");
		
		s1 = Stream.of("Str1","str2");
		s1.forEach(System.out::println);
		
		System.out.println("---------");
		String ary[] = {"S","t","l","a","K"};
		s1 = Stream.of(ary);	
		s1.forEach(System.out::println);
		
		System.out.println("---------");
		s1 = Stream.of(ary);	
		s1.parallel().forEachOrdered(System.out::println);
		
		 Stream<String> stream  = Stream.<String>builder()
			        .add("XML")
			        .add("Java")
			        .add("CSS")
			        .add("SQL")
			        .build();
			    stream.forEach(System.out::println);
			  
	}

}
