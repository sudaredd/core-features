package core.util;

import java.util.HashMap;
import java.util.Map;

public class MapCompute {

	public static void main(String[] args) {

		Map<String, Double> map = new HashMap<>();
		
		map.put("A", 1.0);
		map.put("B", 2.0);
		map.put("C", 3.0);
		double val = 0.25;
		map.compute("C", (s,d)->d==null? 0 : d+val);
		map.compute("D", (s,d)->d==null? 0 : d+val);
		map.entrySet().forEach(e->System.out.println("k:"+e.getKey() + " ,value:"+e.getValue()));
		
	}

}
