package project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class project3 {
	/*public static void main(String[] args) {
		List<Student> student = new ArrayList<>();
		student.add(new Student("donovan","mitchell",34));
		student.add(new Student("Mike","conley",68));
		student.add(new Student("bojan", "bogdanovic", 75));
		student.add(new Student("Rudy", "Gobert", 55));
		student.add(new Student("Joe", "ingle", 78));
		student.add(new Student("dante","exum",7));
		
	}*/
	public static List<Student> main() {
		List<String[]> contents = new ArrayList<>();
		List<Student> student;
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/data.txt"))){
			contents = stream
					.map(s -> s.replaceAll("\\s","").split(","))
					.collect(Collectors.toList());
		}
		catch (IOException e) {
			System.out.println("Exception has occurred: " + e);
		}
		
		student = contents.stream()
				.map(t-> new Student(t[0],t[1], Integer.parseInt(t[2])))
				.collect(Collectors.toList());
		
		return student;
	}
	
	
	public static int findGradebyName(String firstName, String lastName, List<Student> student) {
		if (firstName.length() <= 0 || lastName.length() <= 0) {
			System.out.println("No input");
		}
		
		int target;
		target = student.stream()
				.filter(t-> t.getfirstName().equalsIgnoreCase(firstName) &&
							t. getlastName().equalsIgnoreCase(lastName))
				.findFirst()
				.map(t -> t.getGrade())
				.orElseGet(() -> {
					System.out.println("cannot find this student!");
					return null;
				});
		return target;
	}
	
	public static String findMaxgrade(List<Student>student) {
		Student max;
		max = Collections.max
				(student, Comparator.comparing
						(t-> t.getGrade()));
		String firstName= max.getfirstName();
		//String lastName = max.getlastName();
		
		return firstName;
	}

	public static OptionalDouble findAverage(List<Student>student) {
		OptionalDouble average = student.stream()
				.mapToInt(t -> t.getGrade())
				.average();
		return average;
	}
	
	public static void listbyGrade(List<Student>student) {
		List<Student> list = student.stream()
				.sorted(Comparator.comparing(Student::getGrade).
						reversed()).collect(Collectors.toList());
		list.forEach
		(t -> System.out.println(t.getfirstName()+" "+t.getlastName()+" "+t.getGrade()));
		return;
	}
}


