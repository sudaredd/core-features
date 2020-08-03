package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import core.util.SubListD;

public class SubListDTest {

	private SubListD<Integer> subListD = new SubListD<>();
	
	@Test
	public void testSubL() {
		List<Integer>  list = new ArrayList<Integer>();
		for(int i=0;i<11;i++) {
			list.add(i);
		}
		
		List<List<Integer>> lists = subListD.sublist(list, 10);
		assertEquals(2, lists.size());
		assertEquals(10, lists.get(0).size());
		assertEquals(1, lists.get(1).size());
	}
	@Test
	public void testSubStrL() {
		List<String> strList = Arrays.asList("1","2","3","4","5");
		SubListD<String> sd = new SubListD<>();

		List<List<String>> subLists =sd.sublist(strList, 2);
		
		assertEquals(3, subLists.size());
		assertEquals(2, subLists.get(0).size());
		assertEquals(1, subLists.get(2).size());
	}
}
