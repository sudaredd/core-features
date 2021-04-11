package streams;

import java.io.*;

public class Tst1 {

	 public static void main(String[] args) throws IOException {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    while ((s = in.readLine()) != null) {
		      System.out.println("input:"+s);
		      String ary[] = s.split(";");
		      
		      if(ary.length==2) {
		    	  int numOfElements = Integer.parseInt(ary[1]);
		    	  String items[] = ary[0].split(","); 
		    	  int i=0;
		    	  for(; i+ numOfElements < items.length; i= i+ numOfElements) {
		    		  reverse(items, i, i+ numOfElements-1);
		    	  }
		    	  if(i < items.length) reverse(items, i, items.length-1);
		    	  StringBuilder sb = new StringBuilder();
		    	  for(String ite: items) {
		    	      sb.append(ite).append(",");
		    	  }
		    	  String res = sb.toString();
		    	   System.out.print(res.substring(0, res.length()-1));
		      }
		    }
		  }

	private static void reverse(String[] items, int begin, int end) {
		while(begin < end) {
			String temp = items[begin];
			items[begin] = items[end];
			items[end] = temp;
			begin++; end--;
		}
	}

}
