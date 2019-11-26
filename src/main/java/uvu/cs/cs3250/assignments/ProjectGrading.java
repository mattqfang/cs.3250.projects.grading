package uvu.cs.cs3250.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ProjectGrading {
	
	public static void main(String[] args) {
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/data.txt"))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("Exception has occurred: " + e);
		}
	}
}
