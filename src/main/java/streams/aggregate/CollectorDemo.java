package streams.aggregate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import streams.Employee;

public class CollectorDemo {
	
	public List<String> fiterEmps(String str, List<Employee> emps) {
		return emps.stream()
		.filter(s->s.name().contains(str))
		.map(s->s.name())
		.collect(Collectors.toList());
	}
	
	public Map<Long,String> getMap(List<Employee> emps) {
				
		Map<Long,String> idToNameMap= emps.stream()
        .collect(Collectors.toMap(Employee::getId,  Employee::name));
     System.out.println(idToNameMap);
     
     emps.stream().
     collect(Collectors.toMap(e->e.getId(), e->e.name()));
     
     return idToNameMap;
	}
	
	public String joinNames(List<Employee> emps) {
		return emps.stream()
		.map(Employee::name)
		.collect(Collectors.joining());
	
	}
	
	public String joinNamesWithDelimeter(List<Employee> emps) {
		return emps.stream()
		.map(Employee::name)
		.collect(Collectors.joining(","));
	
	}
}
