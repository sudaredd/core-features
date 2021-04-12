package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

record Student(int id, String name, String grade) {
}

public class StreamSort {

    public List<Student> sortStudentsByName(List<Student> students) {

        return students.stream()
            .sorted(comparing(s -> s.name())).collect(toList());
    }

    public Map<String, Map<String, List<Student>>> groupByNameAndGrade(List<Student> students) {

        return students.stream()
            .collect(Collectors.groupingBy(Student::name, Collectors.groupingBy(Student::grade)));

    }


}
