package streams.aggregate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import streams.Employee;

public class StreamAggregateFunsTest {

	List<Employee> persons = Employee.employees();
	
	@Test 
	public void testSum() {
		double sum = StreamAggregateFuns.sum(persons);
		assertEquals(21143, (long)sum);
	}
	
	@Test
	public void testMax() {
		Employee emp = StreamAggregateFuns.max(persons);
		assertNotNull(emp);
		assertEquals("Jack", emp.name());
		assertEquals(7100, (long)emp.getIncome());
		assertEquals(7100, (long)StreamAggregateFuns.max1(persons));
	}
	
	@Test
	public void testCount() {
		long count = StreamAggregateFuns.count(persons, "Ja");
		assertEquals(4, count);
	}
}
