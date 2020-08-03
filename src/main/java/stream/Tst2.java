package stream;
import java.io.*;

public class Tst2 {

	public static void main(String[] args) throws IOException {

		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    while ((s = in.readLine()) != null) {
		      String ary[] = s.split(",");
		      if(ary.length < 2) {
		    	  System.err.println("Invalid input, Test input: babgbag,bag");
		    	  continue;
		      }
		     int num = utilM(ary[0].toCharArray(), ary[1].toCharArray(), 0, 0);
		     System.out.println(num);
		    }
		    
	}
	static int utilM(char[] a, char[] b, int i, int j) {
		if (j == b.length) {
			if (i == a.length && a[i-1] != b[j-1]) {
				return 0;
			}
			else{
				System.out.println("returing 1");
				return 1;
			}
		} 
		if (i == a.length) return 0;
System.out.println("a[i]:"+a[i] + " ,b[j]: "+b[j] + " , i:"+i + " ,j:"+j);
		if (a[i] == b[j]) 
			return utilM(a, b, i+1, j+1) + utilM(a, b, i+1, j);
		else 
			return utilM(a, b, i+1, j);
	}

}
