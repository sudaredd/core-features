package streams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class FlatMapD {

	public static class Student {
		private String name;
		private Set<String> books;

		public void addBook(String book) {
			if (this.books == null) {
				this.books = new HashSet<>();
			}
			this.books.add(book);
		}

		public Student(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public Set<String> getBooks() {
			return books;
		}
	}

	public List<String> allBooks(List<Student> students) {
		return students.stream()
		.map(s->s.getBooks())
		.flatMap(b->b.stream())
		.distinct()
		.collect(Collectors.toList());
	}
}
