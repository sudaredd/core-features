package lambda.functional.predicate;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;import java.util.function.Predicate;


public class FileFinder {

	static Predicate<File> javaP = f1-> f1.getName().endsWith(".java");
	
	static Predicate<File> isDirectry = File::isDirectory;
	
	public static void main(String[] args) {

		File f = new File("C:/Users/Sudarsana/git/core8");
		Queue<File> files = new LinkedList<File>();
		files.add(f);
		List<File> javaFiles = new ArrayList<File>();
		javaFiles.add(f);
		
		while(!files.isEmpty()) {
			File file = files.poll();
			Arrays.stream(file.listFiles())
			.forEach((f1)-> {
				if(javaP.test(f1)) {
					javaFiles.add(f1);
				}
				if(isDirectry.test(f1)) {
					files.add(f1);
				}
			}
			);
		}
		
		javaFiles.forEach(System.out::println);
	}

}
