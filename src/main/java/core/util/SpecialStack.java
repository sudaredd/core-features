package core.util;

import java.util.Stack;

public class SpecialStack<T extends Comparable<? super T>> extends Stack<T> {

	private Stack<T> minStack = new Stack<>();
	
	@Override
	public T push(T item) {
		T ret = super.push(item);
		if(minStack.isEmpty()) {
			minStack.push(item);
		} else {
			T min = minStack.peek();
			if(item.compareTo(min) < 0) {
				minStack.push(item);
			}
		}
		return ret;
	}


	@Override
	public synchronized T pop() {
		T item = super.pop();
		T min = minimum();
		if(min == item) {
			minStack.pop();
		}
		return item;
	}
	
	public T minimum() {
		return minStack.peek();
	}


	@Override
	public synchronized T peek() {
		// TODO Auto-generated method stub
		return super.peek();
	}


	@Override
	public String toString() {
		return "SpecialStack [minStack=" + minStack + "]," + super.toString();
	}


	public static void main(String[] args) {

		SpecialStack<Integer> stack = new SpecialStack<Integer>();
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(6);
		stack.push(2);
		stack.push(10);
		stack.push(1);
		stack.push(1);
		
		int min = stack.minimum();
		if (min != 1) {
			System.err.println("error");
		}
		stack.pop();
		stack.pop();
		min = stack.minimum();
		if (min != 2) {
			System.err.println("error");
		}
		
		System.out.println(stack);
	}

}
