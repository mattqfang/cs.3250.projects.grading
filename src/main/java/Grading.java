import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.net.ssl.SSLContext;

public class Grading {
	private static List<Person> personList = new ArrayList<Person>();
	
	public Grading() throws IOException {
		File filePath = new File("src/main/resources/data.txt");
	    String fullPath = filePath.getAbsolutePath();
		
		try (Stream<String> lines = Files.lines(Paths.get(fullPath))) {
		
		personList = lines
				.map(s -> new Person(s.substring(0, s.indexOf(",")), 
						s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")), 
						Double.valueOf(s.substring(s.lastIndexOf(",") + 1, s.length()))))
				.collect(Collectors.toList());
		}
	}

	public Double GetGradeByPerson(String firstName, String lastName) {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(p -> p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.map(p -> p.getGrade())
				.orElseGet(() -> {
					return -1.0;	
				});
	}
	
	public String GetMaxGradeWithName() {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.sorted((p1,p2) -> p2.getGrade().compareTo(p1.getGrade()))
				.map(p -> p.getFirstName() + " " + p.getLastName() + " " + p.getGrade())
				.findFirst()
				.orElseGet(() -> {
					return "List is Empty";
				});
	}

	public double GetAvgGrade() {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.mapToDouble(p -> p.getGrade())
				.average()
				.orElseGet(() -> {
					return -1.0;	
				});			
	}

	public List<String> GradeListOrderedByGrade() {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.sorted((p1,p2) -> p2.getGrade().compareTo(p1.getGrade()))
				.map(p -> p.getFirstName() + " " + p.getLastName() + " " + p.getGrade())
				.collect(Collectors.toList());
	}
}
