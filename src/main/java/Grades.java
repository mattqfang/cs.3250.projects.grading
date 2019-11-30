import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

public class Grades {
	private static List<Student> students;

	public Grades (Path path) throws IOException {
		List<String> lines;

		lines = Files.readAllLines(path);

		students = lines.stream()
			.map(s -> new Student(s))
			.collect(Collectors.toList());
	}

	// This assumes that the data will not have duplicate first/last name combos
	public Double getGradeByName (String first_name, String last_name) throws NoSuchElementException, IllegalArgumentException {
		Optional.ofNullable(first_name).orElseThrow(IllegalArgumentException::new);
		Optional.ofNullable(last_name).orElseThrow(IllegalArgumentException::new);
		return students.stream()
			// Allow for incorrect case in names, remove trailing/leading whitespace
			.filter(s -> s.getFirstName().equalsIgnoreCase(first_name.trim()) && s.getLastName().equalsIgnoreCase(last_name.trim()))
			.findAny()
			.orElseThrow(NoSuchElementException::new)
			.getGrade();
	}

	public String getMaxGrade () {
		Student teachers_pet = students.stream()
			.sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
			.findFirst()
			.get();
		return teachers_pet.getFullRecord();
	}
	
	public Double getAverageGrade () {
		return students.stream()
			.mapToDouble(s -> s.getGrade())
			.average()
			.getAsDouble();
	}

	public List<String> getAllByGrade () {
		return students.stream()
		.sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
		.map(s -> s.getFullRecord())
		.collect(Collectors.toList());
	}

	// public String throwup {
	//     students.stream()
	//         .foreach(println(
	// }
}
