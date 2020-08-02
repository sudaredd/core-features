package streams;

import java.util.Iterator;
import java.util.stream.Stream;

public class StreamIte {

	public static void main(String[] args) {

		Iterator<String> it = Stream.of("1,2,3,4,5".split(",")).iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
