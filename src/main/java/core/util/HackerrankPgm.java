package core.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HackerrankPgm {

	static void mergeSortingArrays() {
		int a[] = {3,4,5,7};
		int b[] = {2,4,6};
		
		int c[] = new int[a.length+b.length];
		int i = 0, j = 0, k = 0;
		while(i<a.length && j<b.length) {
			if(a[i] < b[j]) {
				c[k++]=a[i++];
			} else {
				c[k++]=b[j++];
			}
		}
		while(i<a.length) {
			c[k++]=a[i++];
		}
		while(j<b.length) {
			c[k++]=b[j++];
		}
		for(int a1=0; a1<c.length;a1++) {
			System.out.print(c[a1]+  ",");
		}
		System.out.println();
	}
	public static void orderitems() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("{", "}");map.put("(", ")");map.put("[", "]");
		String str = "({[{]})";
		char [] chars = str.toCharArray();
		boolean flag = true;
		int elementsToSearch = chars.length%2==0 ? chars.length/2 : 1+chars.length/2;
		for(int i=0;i<elementsToSearch;i++) {
			char item = chars[i];
			String val = map.get(item+"".trim());
			if(val!=null && chars[chars.length-i-1]==val.charAt(0)) {
				continue;
			} else {
				System.out.println("not closed in order at pos:"+ i + " for item:"+item + " , the corresponding is:"+chars[chars.length-i-1]);
				flag = false;
			}
		}
		if(flag) System.out.println("all are ordered");
	}
	
	public static void fib() {
		int count = 15;
		int fib[] = new int[count];
		fib[0]=0;fib[1]=1;
		for(int i=2; i<count; i++) {
			fib[i]=fib[i-1]+fib[i-2];
		}
		for(int i:fib) {
			System.out.print(i+",");
		}
	}
	public static void main(String[] args) {
		mergeSortingArrays();
		orderitems();
		fib();
		sort(2,4);
	}

	private static void sort(int i, int j) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 100);
		map.put("f", 60);
		map.put("g", 110);
		map.put("h", 50);
		map.put("i", 90);
		map.put("k", 70);
		map.put("L", 80);

		Comparator<Map.Entry<String, Integer>> byValue = (entry1, entry2) -> entry1
				.getValue().compareTo(entry2.getValue());

		map.entrySet().stream().
				 sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).
				 limit(10).forEach(System.out::println);
	}
}