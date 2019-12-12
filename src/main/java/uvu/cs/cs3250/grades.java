package uvu.cs.cs3250;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class grades {
	
	private List<Person> studentList;
	
	private Person createPerson(String line) {
		String[] things = line.split(",");
        Person newPerson = new Person();
        newPerson.setFirstName(things[0].substring(0,1).toUpperCase()+things[0].substring(1));
        newPerson.setLastName(things[1].substring(0,1).toUpperCase()+things[1].substring(1));
        newPerson.setGrade(Integer.parseInt(things[2]));
        return newPerson;
    }
    
	public void createStudentList() {
	    try (Stream<String> stream = Files.lines(Paths.get("C:\\work\\cs3250\\cs3250_grades\\cs.3250.projects.grading\\src\\main\\resources\\data.txt"))) {
	    	studentList = stream
	            .map(c -> c.replaceAll(" ",""))
	            .sorted(String.CASE_INSENSITIVE_ORDER)
	            .map(c -> createPerson(c))
	            .collect(Collectors.toList());
	    } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
	    }
	}
	
	public void ListPersonsByGradeOrder() {
		createStudentList();
		studentList
			.stream()
			.sorted(Comparator.comparingInt(Person::getGrade).reversed())
			.forEach(c -> printPerson(c));
	}

	private Object printPerson(Person print) {
		System.out.println(print.getFirstName() + " " + print.getLastName() + ", " + print.getGrade());
		return null;
	}
	
	public int FindGrade(String firstName, String lastName) {
		createStudentList();
		int foundGrade;
		List<Person> matchingStudents = studentList
			.stream()
			.filter(c -> c.getFirstName().equals(firstName))
			.filter(c -> c.getLastName().equals(lastName))
			.collect(Collectors.toList());
		if (matchingStudents.size() == 1) {
			foundGrade = matchingStudents.get(0).getGrade();
		} else if (matchingStudents.size() < 1) { 
			foundGrade = -1;
		} else {
			foundGrade = -2;
		}
		return foundGrade;
	}

	public Person FindMaxGrade( ) {
		createStudentList();
		List<Person> hiToLowList = studentList
			.stream()
			.sorted(Comparator.comparingInt(Person::getGrade).reversed())
			.collect(Collectors.toList());
		return hiToLowList.get(0);
	}
	
	public int FindAvgGrade() {
		createStudentList();
		OptionalDouble avgGrade = studentList
				.stream()
				.mapToInt(Person::getGrade)
				.average();
		return (int)(avgGrade.orElse(-1));
	}
}