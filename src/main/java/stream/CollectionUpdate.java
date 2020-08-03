package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionUpdate {

	public static void main(String[] args) {

		List<String> li = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			li.add("" + i);
		}
		Stream<String> st = li.stream();
		li.add("5");
		System.out.println(li);
	//List<String> updated=
			st.
		filter(i-> {
			li.add("9");
			return true;
		});//.collect(Collectors.toList());
		//forEach(System.out::print);
	System.out.println();
	}

}
