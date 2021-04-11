package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StreamSortTest {

    @Test
    public void testSortByName() {

        StreamSort streamSort = new StreamSort();
        List<Student> students = streamSort.sortStudentsByName(List.of(
            new Student(1, "darsan", "Btech"),
            new Student(2, "kasireddy", "Masters"),
            new Student(3, "Abhi", "Graduate")
            )
        );
        Assert.assertEquals("Abhi", students.get(0).name());
        Assert.assertEquals("darsan", students.get(1).name());
        Assert.assertEquals("kasireddy", students.get(2).name());
    }
}
