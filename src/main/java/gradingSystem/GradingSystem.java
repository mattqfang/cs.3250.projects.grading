package gradingSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradingSystem {
	List<Person> list;

	public static void main(String[] args) {
		GradingSystem gs = new GradingSystem();
		//System.out.println(gs.findGradeByName("oe","ingle"));
		gs.namesSortedByGrade();
	}
	
	public int averageGrade() {
		Double avgGrd = list.stream()
			.mapToInt(p -> p.getScore())
			.average()
			.getAsDouble();
		System.out.println((int)Math.round(avgGrd));
		return (int)Math.round(avgGrd);
	}
	
	public void namesSortedByGrade() {	//sorted in descending order
		list.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(p -> System.out.println(p.getFirst() + " " + p.getLast()));
	}
	
	public String findGradeByName(String first, String last) {
		return list.stream()
			.filter(s -> s.getFirst().equalsIgnoreCase(first) && s.getLast().equalsIgnoreCase(last))
			.findAny()
			.orElse(new Person("Person not","found","-1"))
			.printPerson();
	}	//	"Person not found" to handle exceptions
	
	public String findMaxGrade() {
		return list.stream()
			.max((p1,p2)->p1.compareTo(p2))
			.get()
			.printPerson();
	}
	
	GradingSystem(){	//constructor
		readFile();
	}

	// read from file, store into person objects, close file
	private void readFile() {	
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/data.txt"))){
			list = stream.map(s -> makePerson(s))
				.collect(Collectors.toList());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Person makePerson(String s) {
		String[] split = s.split(",");
		return (new Person(split[0], split[1], split[2]) );
	}
}