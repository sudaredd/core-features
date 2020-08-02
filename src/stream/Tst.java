package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;


public class Tst {

	public static void main(String[] args) throws IOException {

		
		Map<String, Integer> map = new LinkedHashMap<>();
		
		map.compute("C", (s,d)->d==null? 1 : d+1);
		map.compute("C", (s,d)->d==null? 1 : d+1);
		map.compute("a", (s,d)->d==null? 1 : d+1);
		
		System.out.println(map);
		

String s1 = "a.b.c -- []";
String ary[] = s1.split("--");
System.out.println("array:"+ary[0]);
		
		
try(BufferedReader br = new BufferedReader(new FileReader(""))) {
	
} catch (Exception e) {
	// TODO: handle exception
}

BufferedWriter bwr = new BufferedWriter(new FileWriter("a.txt"));

map.entrySet().forEach(s-> {
	try {
		bwr.write(s.getKey()+" "+s.getValue());
		bwr.newLine();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
});

bwr.write("");
bwr.newLine();


	}

}
