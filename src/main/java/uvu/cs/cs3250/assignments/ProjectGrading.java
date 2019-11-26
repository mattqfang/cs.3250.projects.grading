package uvu.cs.cs3250.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProjectGrading {
	
	public static void main(String[] args) {
		List<String[]> stringContents = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/data.txt"))) {
			stringContents = stream
				.map(s -> s.replaceAll("\\s","").split(","))
				.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Exception has occurred: " + e);
		}
		
		//Print out each list of string array contents
		stringContents.stream()
			.map(k -> k[0] + " " + k[1] + " " + k[2])
			.forEach(System.out::println);
		
		System.out.println(findStudentGrade("mike", "conley", stringContents));
	}
	
	
	public static String findStudentGrade(String firstName, String lastName, List<String[]> students) {
		return students.stream()
			.filter(p -> p[0].equalsIgnoreCase(firstName) &&
					p[1].equalsIgnoreCase(lastName))
			.findFirst()
			.map(p -> p[2])
			.orElse("Grade not available");
	}

}
