package uvu.cs.cs3250.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProjectGrading {
	
	public static void main(String[] args) {
		List<String[]> stringContents = new ArrayList<>();
		List<Student> students;
		
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/data.txt"))) {
			stringContents = stream
				.map(s -> s.replaceAll("\\s","").split(","))
				.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Exception has occurred: " + e);
		}
		
		students = stringContents.stream()
			.map(s -> new Student(s[0], s[1], Integer.parseInt(s[2])))
			.collect(Collectors.toList());
		
		//Print out each list of string array contents
		students.stream()
			.map(k -> k.getFirstName() + " " + k.getLastName() + " " + k.getGrade())
			.forEach(System.out::println);
		
		System.out.println(findStudentGrade("mike", "conley", students));
	}
	
	
	public static int findStudentGrade(String firstName, String lastName, List<Student> students) {
		return students.stream()
			.filter(s -> s.getFirstName().equalsIgnoreCase(firstName) &&
					s.getLastName().equalsIgnoreCase(lastName))
			.findFirst()
			.map(s -> s.getGrade())
			.orElse(0);
	}
/*
	public static String findStudentWithMaxGrade(List<String[]> students) {
		return students.stream()
			.sorted(Comparator.comparing(String[].class))
			.findFirst()
			.map(s -> s[0] + " " + s[1])
			.orElseGet(() -> {
				System.out.println("cannot find this dude");
				return null;
			});
	}
	
	public static Double findAverageAgeByCity(String city, List<Person> allPersons) {
		return allPersons.stream()
			.filter(p -> p.getAddress() != null)
			.filter(p -> city.equalsIgnoreCase(p.getAddress().getCity()))
			.mapToInt(p -> p.getAge())
			.average()
			.getAsDouble();
	}
	*/
	
	static class Student {
		private String firstName;
		private String lastName;
		private int grade;
		
		public Student(String firstName, String lastName, int grade) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.grade = grade;
		}
		
		public String getFirstName( ) {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName( ) {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public int getGrade( ) {
			return grade;
		}
		
		public void setGrade(int grade) {
			this.grade = grade;
		}
	}
}
