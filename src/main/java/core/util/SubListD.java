package core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubListD<T> {

	public  List<List<T>> sublist(List<T> list, int size) {
		int[] ary=  IntStream.rangeClosed(0, list.size())
		.filter(i-> (i==list.size()|| i%size==0))
		.toArray();
		
		return IntStream.range(0, ary.length-1)
		.mapToObj(i->list.subList(ary[i], ary[i+1]))
		.collect(Collectors.toList());
		
	}
}
