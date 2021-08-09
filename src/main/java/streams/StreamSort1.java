package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSort1 {

    public static void main(String[] args) {
        List<Employee> persons = Employee.employees();
        System.out.println(persons);
        List<Employee> collect = persons.stream()
            .sorted(Comparator.comparing(Employee::name))
            .collect(Collectors.toList());
        System.out.println(collect);
    }
}
