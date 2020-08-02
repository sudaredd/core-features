package lambda.functional;

interface Foo {
	  public String method(String string);
}
public class LambdaInnerDemo {

	String value = "class value";
	public static void main(String[] args) {
		
		new LambdaInnerDemo().compareBothImpl();
	}
	private void compareBothImpl() {

		Foo f = new Foo() {
			String value = "Inner class value";
			@Override
			public String method(String string) {
				// TODO Auto-generated method stub
				return this.value;
			}
		};
		
		Foo f1 = (str)-> {
			String value = "Lambda class value";
			return this.value;
		};
		
		System.out.println(f.method(null) + " ,"+f1.method(null));
	}

}
