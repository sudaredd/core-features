package lambdas;

public class Apple {
	private int size;
	private String colour;
	public Apple(int size, String colour) {
		super();
		this.size = size;
		this.colour = colour;
	}
	public int getSize() {
		return size;
	}
	public String getColour() {
		return colour;
	}
	@Override
	public String toString() {

		return "Apple [size=" + size + ", colour=" + colour + "]";
	}
	
}
