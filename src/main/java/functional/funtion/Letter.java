package functional.funtion;

public class Letter {

	public static String addHeader(String text) {
		System.out.println("header input:"+text);

		return "From Raoul, Mario and Alan: " + text;
	}

	public static String addFooter(String text) {
		System.out.println("footer input:"+text);
		return text + " Kind regards";
	}

	public static String checkSpelling(String text) {
		System.out.println("checkspell input:"+text);

		return text.replaceAll("labda", "lambda");
	}
}
