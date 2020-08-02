package stream;

import java.util.Arrays;
import java.util.List;

public class ListLoop {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(9,8,7,6,5,4,3,2,1);

		for(int i=0, size=list.size(); i < size; i++) {
			System.out.println(list.get(i));
		}
	}

}
