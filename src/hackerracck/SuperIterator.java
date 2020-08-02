package hackerracck;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class SuperIterator<T> implements Iterator<T> {
	
	Queue<Iterator<T>> iterators = new LinkedBlockingQueue();
	
	SuperIterator(Collection<Iterator<T>> iters) {
		iters.stream().filter(Iterator::hasNext).forEach(iterators::add);
	}

	public static void main(String[] args) {

		Iterator one  = Arrays.asList("1").iterator();
		Iterator two  = Arrays.asList("3","4","5").iterator();
		
		SuperIterator superIterator = new SuperIterator(Arrays.asList(one,two));
		while(superIterator.hasNext()) {
			System.out.println(superIterator.next());
		}
	}

	@Override
	public boolean hasNext() {
		while(!iterators.isEmpty()) {
			Iterator<T> i = iterators.peek();
			if(i.hasNext()) {
				return true;
			} else {
				iterators.remove(i);
			}
		}
		return false;
	}

	@Override
	public T next() {
		T val=null;
		while (!iterators.isEmpty()) {
			Iterator<T> i = iterators.peek();
			if (!i .hasNext()) {
				iterators.remove(i);
				continue;
			}
			val= i.next(); break;
		}
		return val;
	}

}
