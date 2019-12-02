package uvu.cs.cs3250.grading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradingSystem 
{	
	public static List<Person> readFile(String filename)
	{
		List<Person> persons = new ArrayList<Person>();
		
		try(Stream<String> stream = Files.lines(Paths.get(filename)))
		{	
			persons = stream
					.map(s -> {
						String[] person = s.split(",");
						return new Person(person[0].trim(), person[1].trim(), Integer.valueOf(person[2].trim()));
					})
					.collect(Collectors.toList());
		}
		catch(IOException e) { e.printStackTrace(); }
		
		return persons;
	}
	
	// Finds the grade of the person with the passed in first and last name
	public static int findGradeByPerson(List<Person> persons, String firstname, String lastname)
	{
		return persons.stream()
				.filter(p -> p.getFirstName().equalsIgnoreCase(firstname) && p.getLastName().equalsIgnoreCase(lastname))
				.findFirst()
				.map(p -> p.getGrade())
				.get();
	}
	
	// Find the name of the person with the max grade
	public static String findNameWithMaxGrade(List<Person> persons)
	{
		int maxGrade = persons.stream()
						.map(p -> p.getGrade())
						.max(Integer::compare)
						.get();
		
		return persons.stream()
				.filter(p -> p.getGrade() == maxGrade)
				.findFirst()
				.map(p -> p.getFirstName() + " " + p.getLastName())
				.get();
	}
	
	// Get the average grade of all persons in the list
	public static double getAvgGrade(List<Person> persons)
	{
		return persons.stream()
				.mapToInt(p -> p.getGrade())
				.average()
				.getAsDouble();
	}
	
	// Print out everyone in the list
	public static void listAllPersons(List<Person> persons)
	{
		persons.stream()
		 .sorted(Comparator.comparing(Person::getGrade))
		 .forEach(System.out::println);
		 
	}
}
