package stream;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import stream.FlatMapD;
import stream.Student;
import org.junit.Test;

public class FlatMapDTest {

	@Test
	public void testAllBooks() {
		FlatMapD d = new FlatMapD();
		Student obj1 = new Student("darsan");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student("Sudar");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		
		List<String> al = d.allBooks(list);
		System.out.println(al);
		assertEquals(4, al.size());
		assertTrue(al.contains("Spring Boot in Action"));
		assertTrue(al.contains("Effective Java (2nd Edition)"));
		assertTrue(al.contains("Java 8 in Action"));
		assertTrue(al.contains("Learning Python, 5th Edition"));
		
	}

}
