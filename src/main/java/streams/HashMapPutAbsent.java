package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapPutAbsent {

	public static void main(String[] args) {

		Map<Integer, List<String>> map = new HashMap<>();
		System.out.println(map);
		map.computeIfAbsent(2, ArrayList::new).add("2");
		map.computeIfAbsent(1, ArrayList::new).add("2");
		map.computeIfAbsent(1, ArrayList::new).add("3");
		
		System.out.println(map);
		
		Map<String, String> mapUpdate = new HashMap<>();
		List<String> list =  Arrays.asList("one","two","fhree");
		list.forEach(s->mapUpdate.computeIfAbsent(""+s.charAt(0), String::new).concat(":").concat(s));
		
		System.out.println("mapU:"+mapUpdate);
	}

}
