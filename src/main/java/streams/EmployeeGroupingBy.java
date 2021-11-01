package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeGroupingBy {
    public static void main(String[] args) {
        Map<Employee.Gender, List<Employee>> geneders = Employee.employees().
            stream().
            collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(geneders);

        System.out.println("group by with count");

        Map<Employee.Gender, Long> collect = Employee.employees().
            stream().
            collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(collect);


        String str[] = {"1","5","6"};
        List<Integer> x = Arrays.asList(new Integer[]{1, 9, 88});
        List<String> x1 = Arrays.asList(str);
        System.out.println(x);
        System.out.println(x1);
        System.out.println(Arrays.asList("a,b,c".split(",")));
    }
}
