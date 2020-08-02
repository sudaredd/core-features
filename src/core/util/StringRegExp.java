package core.util;

public class StringRegExp {

	public static void main(String[] args) {
		String prim_exch="PE";
		System.out.println(primExch(" .Ulllll", prim_exch));
		System.out.println(primExch(" .Blllll", prim_exch));
		System.out.println(primExch(" .Ylllll", prim_exch));
		System.out.println(primExch(" .Y", prim_exch));
		System.out.println(primExch(".Y", prim_exch));
		System.out.println(primExch(".U", prim_exch));
	}

	private static String primExch(String reuters_ric, String prim_exch) {
		if(reuters_ric.matches("^( .U).*")) {
			prim_exch= "OPQ";
		} else if(reuters_ric.matches("^( .B).*")) {
			prim_exch= "BOX";
		} else if(reuters_ric.matches("^( .Y).*")) {
			prim_exch= "ISE";
		}
		return prim_exch;
	}
}
