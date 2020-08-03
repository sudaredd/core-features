package stream.aggregate;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stream.aggregate.CollectorDemo;
import org.junit.Test;

import stream.Employee;

public class CollectorDemoTest {

	CollectorDemo c = new CollectorDemo();
	List<Employee> persons = Employee.persons();
	
	@Test
	public void testFiterEmps() {
		List<String> actualL = c.fiterEmps("Ja", persons);
		List<String> expectedL = Arrays.asList("Jake", "Jack", "Jane", "Jason");
		assertEquals(expectedL, actualL);
	}
	
	@Test
	public void testCollectorMaps() {
		Map<Long, String> exptectedMap = c.getMap(persons);
		
		Map<Long, String> map = new HashMap<>();
		String str = "1=Jake, 2=Jack, 3=Jane, 4=Jode, 5=Jeny, 6=Jason";
		for(String s: str.split(",")) {
			s=s.trim();
			map.put(Long.parseLong(s.substring(0,s.indexOf("="))), s.substring(s.indexOf("=")+1));
		}
		assertEquals(exptectedMap, map);
	}
	
	@Test
	public void testJoin() {
		assertEquals("JakeJackJaneJodeJenyJason", c.joinNames(persons));
		assertEquals("Jake,Jack,Jane,Jode,Jeny,Jason", c.joinNamesWithDelimeter(persons));
	}

}
