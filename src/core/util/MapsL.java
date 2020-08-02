package core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapsL {

	public static void main(String[] args) {

		Map<String, String> mapT = new HashMap<>();
		Map<String, String> mapD = new HashMap<>();
		
		mapD.put("FTES", "FT");
		mapD.put("MBS_MQ", "FT");
		
		mapT.put("Alphaues", "FTES");
		mapT.put("AlphauesQ", "FTES");
		mapT.put("CreditOne", "FTES");
		
		Stream<String> des =mapD.keySet().stream();
		Stream<String> ts = mapT.entrySet().stream().
					 filter(e->mapD.containsKey(e.getValue())).
					 map(e->e.getKey());

		String res = Stream.concat(des,ts).collect(Collectors.joining("/","[","]"));
		
		System.out.println(res);
	}

}
