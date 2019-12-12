package uvu.cs.cs3250.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Pair;

public class GradingSystem {
	List<String> fileLines = Collections.emptyList();
	
	public GradingSystem() {
		//String fileName = "C:\\Users\\lupus\\cs3250\\GradingSystem\\cs.3250.projects.grading\\src\\main\\resources\\data.txt";
		String fileName = "src/main/resources/data.txt";
		try {
			fileLines = Files.readAllLines(Paths.get(fileName));
		}
	
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/* Function used to find the person's grade based
	   on their name (first and last) */
	public Integer findGradeByName(String firstName, String lastName) {
		//String gradeString = "";
		//gradeString = 
		return fileLines.stream()
			.filter(s -> s.substring(0, s.indexOf(",")).trim()
					.equalsIgnoreCase(firstName) &&
					s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")).trim()
					.equalsIgnoreCase(lastName))
			.findFirst()
			.map(s -> Integer.parseInt(s.substring(s.lastIndexOf(",") + 1).trim()))
			.orElseGet( () -> {
				System.out.println("Error! Cannot find this person");
				return null;
			});
	}
	
	
	/* Function used to find the highest grade in the file
	   and the person's name who earned it */
	public Pair<Integer, String> findMaxGradeWithName() {
		Integer maxGrade = fileLines.stream()
				.mapToInt(s -> Integer.parseInt(s.substring(s.lastIndexOf(",") + 1).trim()))
				.max()
				.getAsInt();
		
		String maxName = fileLines.stream()
				.filter(s -> Integer.parseInt(s.substring(s.lastIndexOf(",") + 1).trim())
						== maxGrade)
				.findFirst()
				.map(s -> s.substring(0, s.indexOf(",")).trim() +
						" " + s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")).trim())
				.orElseGet(() -> {return null;});
		
		return Pair.with(maxGrade, maxName);
				
	}
	
	
	//Function used to find the average of the grades in the file
	public Double findGradeAverage() {
		return fileLines.stream()
				.mapToDouble(s -> Double.parseDouble(s.substring(s.lastIndexOf(",") + 1).trim()))
				.average()
				.getAsDouble();
	}
	
	
	/* Function used to create a list of the people's names
	   ordered by their grades (from highest to lowest) */
	public List<String> nameListByGrade() {
		return fileLines.stream()
			//.filter(s -> Integer.parseInt(s.substring(s.lastIndexOf(",") + 1)))\
			.sorted(Comparator.comparingInt(s ->
				Integer.parseInt(s.toString().substring(s.toString().lastIndexOf(",") + 1).trim())).reversed())
			.map(s -> s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")).trim() + " " + s.substring(0, s.indexOf(",")).trim())
			.collect(Collectors.toList());
	}
}
