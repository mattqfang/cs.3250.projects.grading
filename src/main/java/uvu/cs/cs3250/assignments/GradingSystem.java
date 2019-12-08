package uvu.cs.cs3250.assignments;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradingSystem {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("donovan", "mitchell", 34));
		students.add(new Student("Mike", "conley", 68));
		students.add(new Student("bijan", "bogdanovic", 75));
		students.add(new Student("Rudy", "Gobert", 55));
		students.add(new Student("Joe", "ingle", 78));
		students.add(new Student("dante", "exum", 7));
		
		
	}
	public static Integer findByFirstAndLastName(String first, String last){
		return students.stream()
				.filter(s -> s.getFirstName().equalsIngoreCase(first) &&
							 s.getLastName().equalsIngoreCase(last))
				.findFirst()
				.map(s -> s.getGrade())
				.orElseGet(() -> {
					System.out.println("Can't find this person. Try again");
					return null;
				});
	}
	
	public static List<Student> findMaxGrade(){
		return students.stream()
				.mapToInt(g -> g.getGrade().getMax());	
	}
	
	public static List<Student> findAverageGrade(){
		return students.stream()
				.mapToInt(g -> g.getGrade().getAverage());
				
	}
	
	public static List<Student> printList(){
		return students.stream()
				.mapToInt(g -> g.getGrade().sorted().forEach(System.out::println));
	}
}
