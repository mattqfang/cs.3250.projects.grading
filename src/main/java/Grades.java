import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/*
1. find the grade for a given person (first name and last name)

2. find out the maximum grade with the name

3. find out the average grade.

4. list all the persons (last name and first name) ordered by the grade
*/
public class Grades {
	
	//Function that reads file to Strings
	// andThen function that maps Strings to Students
	// andThen function that maps Students to List
	
	private static List<Student> students;
	
	public static final Function<String, Student> createStudent = str ->{
		List<String> splitList = Arrays.asList(str.split(",")).stream().map(w -> w.trim().toLowerCase()).collect(Collectors.toList());
		return new Student(splitList.get(0), splitList.get(1), Integer.parseInt(splitList.get(2)));
	};
	
	//Read text file - return String - create list of persons
	public static boolean InitializeList(String filepath) {
		try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
			students = stream.map(line -> createStudent.apply(line))
					.collect(Collectors.toList());	
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static void printList() {
		students.stream().forEach(p->System.out.println(p));
	}
	
	public static Integer findGradeByPerson(String firstName, String lastName) {
		return students.stream()
				.filter(p -> p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.map(p -> p.getGrade())
				.orElseGet(()->{
					System.out.println(firstName + " " + lastName + " does not exist");
					return null;
				});
	}
	
	public static String findMaxGrade() {
		return students.stream()
				.reduce((p1, p2) -> p1.getGrade() > p2.getGrade() ? p1 : p2)
						.map(p->p.getFirstName() + " " + p.getLastName() +  ": " + p.getGrade())
						.orElseGet(null);					
	}
	
	public static double findAverageGrade() {
		return students.stream()
				.mapToInt(Student::getGrade)
				.average()
				.getAsDouble();
	}
	
	public static void listPersonsByGrade() {
		
	}
	
}
