package stream.aggregate;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import stream.Employee;

public class StreamAggregateFuns {
	public static long count(List<Employee> persons, String name) {
		long jaCount = persons.stream()
		.filter(emp->emp.name().startsWith(name))
		.count();
		
		System.out.println("number of emps name startsWith ja:"+jaCount);
		
		return jaCount;
		
	}

	public static Employee max(List<Employee> persons) {
		Optional<Employee> emp = persons.stream()
		.max(Comparator.comparingDouble(Employee::getIncome));
		System.out.println("highest earner:"+emp.get());
		
		return emp.get();
	}
	
	public static double max1(List<Employee> persons) {
		OptionalDouble emp = persons.stream()
		.mapToDouble(Employee::getIncome)
		.max();
		
		System.out.println("highest sal:"+emp.getAsDouble());
		
		return emp.getAsDouble();
		
	}

	public static double sum(List<Employee> persons) {
		double sum = persons.stream()
		.mapToDouble(Employee::getIncome)
		.sum();
		
		System.out.println("sum of emp income:"+sum);
		return sum;
	}

}
