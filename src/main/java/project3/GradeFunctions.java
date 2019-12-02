package project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradeFunctions {
	private List<Student> gradeBook = new ArrayList<Student>();
	
	// get data from file
	public GradeFunctions() {
		
		try(Stream<String> s = Files.lines(Paths.get("src/main/resources/data.txt"))){
			s.forEach(student -> gradeBook.add(new Student(student)));
		}	
		catch(IOException e) {
			
		}
		
	}
	
	// find grade for give first and last name
	public int getGradeForName(String first, String last) {
		return gradeBook.stream()
			.filter(s -> s.getFirstName().equalsIgnoreCase(first))
			.filter(s -> s.getLastName().equalsIgnoreCase(last))
			.findFirst()
			.map(grade -> grade.getGrade())
			.get();
	}
	
	// mind max grade
	public String getMaxGrade() {
		return gradeBook.stream()
				.sorted((x1, x2) -> x2.getGrade().compareTo(x1.getGrade()))
				.findFirst()
				.map(x -> {return x.getFirstName() + " " + x.getLastName();})
				.get();
	}
	
	// find avg grade
	public double getAvgGrade() {
		return gradeBook.stream()
				.mapToInt(x -> x.getGrade())
				.average()
				.getAsDouble();
	}
	
	// list out all students ordered by grade
	public List<String> ListStudentsByGrade(){
		return gradeBook.stream()
				.sorted((x1, x2) -> x2.getGrade().compareTo(x1.getGrade()))
				.map(x -> {return x.getLastName() + ", " + x.getFirstName();})
				.collect(Collectors.toList());
	}

}
