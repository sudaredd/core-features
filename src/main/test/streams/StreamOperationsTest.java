package streams;

import static org.junit.Assert.assertEquals;

import streams.StreamOperations;
import org.junit.Test;

public class StreamOperationsTest {

	
	@Test
	public void testPeek() {
		int sum = StreamOperations.peekD(new int[]{1,2,3,4,5});
		assertEquals(35, sum);
	}
}
