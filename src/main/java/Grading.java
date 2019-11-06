import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grading {

	public static void main(String[] args) throws IOException {
		List<String> personList;

		try (Stream<String> lines = Files
				.lines(Paths.get("C:\\cs3250\\cs.3250.projects.grading\\src\\main\\resources\\data.txt"))) {
			personList = lines.collect(Collectors.toList());
		}

		personList.stream().forEach(System.out::println);
		System.out.println("1--------------------------");
		System.out.println(GetGradeByPerson(personList, "dante","exum"));
		System.out.println("2--------------------------");
		System.out.println(GetMaxGradeWithName(personList));
		System.out.println("3--------------------------");
		System.out.println(GetAvgGrade(personList));
		System.out.println("4--------------------------");
		GradeListOrderedByGrade(null).forEach(System.out::println);

	}

	// 1. find the grade for a given person (first name and last name)
	public static String GetGradeByPerson(List<String> personList, String firstName, String lastName) {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(x -> x.substring(0, x.indexOf(",")).trim().equalsIgnoreCase(firstName)
						&& x.substring(x.indexOf(",") + 1, x.lastIndexOf(",")).trim().equalsIgnoreCase(lastName))
				.map(s -> s.substring(s.lastIndexOf(",") + 1, s.length()).trim())
				.findFirst()
				.orElseGet(() -> {
					return "No Person Found";	
				});
	}
	
	
	// 2. find out the maximum grade with the name
	public static String GetMaxGradeWithName(List<String> personList) {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.sorted((p1, p2) -> Integer.valueOf(p2.substring(p2.lastIndexOf(",") + 1, p2.length()).trim())
						.compareTo(Integer.valueOf(p1.substring(p1.lastIndexOf(",") + 1, p1.length()).trim())))
				.map(s -> s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")).trim()
						.concat(", ")
						.concat(s.substring(0, s.indexOf(",")).trim())
						.concat(" ")
						.concat(s.substring(s.lastIndexOf(",") + 1, s.length()).trim()))
				.findFirst().orElseGet(() -> {
					return "List is Empty";
				});
	}

	// 3. find out the average grade.
	public static double GetAvgGrade(List<String> personList) {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.mapToDouble(s -> Double.valueOf(s.substring(s.lastIndexOf(",") + 1, s.length())))
				.average().orElseGet(() -> {
					return -1.0;	
				});
	}

	// 4. list all the persons (last name and first name) ordered by the grade
	public static List<String> GradeListOrderedByGrade(List<String> personList) {
		return Optional.ofNullable(personList)
				.orElseGet(Collections::emptyList)
				.stream()
				.sorted((p1, p2) -> Integer.valueOf(p2.substring(p2.lastIndexOf(",") + 1, p2.length()).trim())
						.compareTo(Integer.valueOf(p1.substring(p1.lastIndexOf(",") + 1, p1.length()).trim())))
				.map(s -> s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")).trim()
						.concat(", ")
						.concat(s.substring(0, s.indexOf(",")).trim())
						.concat(" ")
						.concat(s.substring(s.lastIndexOf(",") + 1, s.length()).trim()))
				.collect(Collectors.toList());
	}
}
