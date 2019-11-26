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
		
		System.out.println(findStudentGrade("mike", "conley", students));
		System.out.println(findStudentWithMaxGrade(students));
		System.out.println(findAverageGrade(students));
		listAllStudentsByGrade(students);
	}
	
	
	public static int findStudentGrade(String firstName, String lastName, List<Student> students) {
		return students.stream()
			.filter(s -> s.getFirstName().equalsIgnoreCase(firstName) &&
					s.getLastName().equalsIgnoreCase(lastName))
			.findFirst()
			.map(s -> s.getGrade())
			.orElse(0);
	}

	public static String findStudentWithMaxGrade(List<Student> students) {
		return students.stream()
			.sorted(Comparator.comparing(Student::getGrade).reversed())
			.findFirst()
			.map(s -> s.getFirstName() + " " + s.getLastName() + " " + s.getGrade())
			.orElseGet(() -> {
				System.out.println("No students with grades");
				return null;
			});
	}

	public static Double findAverageGrade(List<Student> students) {
		return students.stream()
			.mapToInt(s -> s.getGrade())
			.average()
			.getAsDouble();
	}
	
	public static void listAllStudentsByGrade(List<Student> students) {
		students.stream()
			.sorted(Comparator.comparing(Student::getGrade))
			.map(k -> k.getFirstName() + " " + k.getLastName() + " " + k.getGrade())
			.forEach(System.out::println);
	}
	
	static class Student {
		private String firstName;
		private String lastName;
		private int grade;
		
		public Student(String firstName, String lastName, int grade) {
			super();
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
